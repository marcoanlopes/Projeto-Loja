package br.edu.up.crud;

//import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CustomerDAO;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dao.SaleDAO;
import br.edu.up.dominio.Customer;
import br.edu.up.dominio.Product;
import br.edu.up.dominio.Sales;

//criar um create Customer;

public class Create {

	public void createProduct() {

		Product product = new Product();
		Scanner scanner = new Scanner(System.in);

//		System.out.println("Adicione o SKU");
//		product.setSku(scanner.nextInt());
		System.out.println("Digite o nome do produto:");
//		scanner.nextLine();
		product.setName(scanner.nextLine());
		System.out.println("Digite a descrição do produto");
		product.setDescription(scanner.nextLine());
		System.out.println("Digite o preco pago pelo produto");
		product.setPurchasePrice(scanner.nextDouble());
		System.out.println("Digite o preco de venda");
		product.setSellingPrice(scanner.nextDouble());
		System.out.println("Digite a quantidade comprada");
		product.setQuantity(scanner.nextInt());

		ProductDAO productDAO = new ProductDAO();
		productDAO.save(product);

	}

	public void createCustomer() {

		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do cliente:");
		customer.setCustomerName(scanner.nextLine());
		System.out.println("Digite o e-mail do cliente: ");
		customer.setEmail(scanner.nextLine());
		System.out.println("Digite o CPF do cliente: ");
		customer.setCpf(scanner.nextLine());
		System.out.println("Digite o endereço do cliente: ");
		customer.setAdress(scanner.nextLine());
		System.out.println("Tipo do telefone: (ex: comercial/residencial/..)");
		customer.setPhoneType(scanner.nextLine());
		System.out.println("Digite o numero de telefone: ");
		customer.setPhoneNumber(scanner.nextLine());
		System.out.println("Deseja deixar alguma anotação?");
		customer.setNote(scanner.nextLine());

		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.save(customer);

	}

	public void sellProduct() {
		SaleDAO saleDAO = new SaleDAO();
		ProductDAO product = new ProductDAO();
		Product saleProduct = new Product();
		String decision;
		Scanner scanner = new Scanner(System.in);
		CustomerDAO customerDAO = new CustomerDAO();

		int salesId = saleDAO.getLastOrder() + 1;

		do {

			System.out.println("Digite o código do produto desejado: ");
			int skuProduct = scanner.nextInt();
			saleProduct = product.findById(skuProduct);

			System.out.println("Digite a quantidade de produtos: ");
			int quantity = scanner.nextInt();
			int quantityProduct = saleProduct.getQuantity();

			if (quantityProduct >= quantity) {

				quantityProduct = quantityProduct - quantity;
				saleProduct.setQuantity(quantityProduct);
				product.updateDAO(saleProduct);

				double priceProduct = saleProduct.getSellingPrice();
				double salePrice = (priceProduct * quantity);
				System.out.println("Total do produto: " + salePrice);

				Sales sale = new Sales();
				sale.setSaleId(salesId);
				sale.setProductSKU(skuProduct);
				sale.setProductQuantity(quantity);
				sale.setProductTotalSale(salePrice);
				saleDAO.save(sale);

			} else {
				System.out.println(
						"Não foi possível realizar a venda. Quantidade disponível para venda: " + quantityProduct);
			}
			System.out.println("Deseja incluir mais um item na venda? (s/n)");
			scanner.nextLine();
			decision = scanner.nextLine();
		} while (decision.equals("s"));
		
//		System.out.println("Deseja vincular a compra a algum cliente? (s/n)");
//		String option = scanner.nextLine();
//		customerDAO.setCustomer();
		
		System.out.println("Venda Realizada com sucesso!");

		
		saleDAO.getInvoice(salesId);
		double totalSalePrice = saleDAO.getSalePrice(salesId);
		
		System.out.println("Valor total dessa venda:" + totalSalePrice);

	}
	
}
