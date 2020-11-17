package br.edu.up.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CustomerDAO;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dao.SaleDAO;
import br.edu.up.dominio.Customer;
import br.edu.up.dominio.Product;
import br.edu.up.dominio.Sales;

//Criar um readCustomer;

public class Read {

	public void readProduct() {
		  ProductDAO productDAO = new ProductDAO();
	        List<Product> productList = productDAO.list();
	        for (Product product : productList) {
	            System.out.println(product);
	        }
	}
	public void readCustomer() {
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> customerList = customerDAO.list();
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}
	public void getBudget() {
		
//		SaleDAO saleDAO = new SaleDAO();
		ProductDAO product = new ProductDAO();
		Product saleProduct = new Product();
		String decision;
		Scanner scanner = new Scanner(System.in);
		List <Sales> budgetList = new ArrayList<>();

//		int salesId = saleDAO.getLastOrder() + 1;

//		int totalQuantityBudget=0;
		double totalPriceBudget=0;
		
		do {
			System.out.println("Digite o código do produto desejado: ");
			int skuProduct = scanner.nextInt();
			saleProduct = product.findById(skuProduct);

			System.out.println("Digite a quantidade de produtos: ");
			int quantity = scanner.nextInt();
//			int quantityProduct = saleProduct.getQuantity();

//				quantityProduct = quantityProduct - quantity;
//				saleProduct.setQuantity(quantityProduct);
//				product.updateDAO(saleProduct);

				double priceProduct = saleProduct.getSellingPrice();
				double salePrice = (priceProduct * quantity);
				System.out.println("Total do produto: " + salePrice);

				Sales sale = new Sales();
//				sale.setSaleId(salesId);
				sale.setProductSKU(skuProduct);
				sale.setProductQuantity(quantity);
				sale.setProductTotalSale(salePrice);
				budgetList.add(sale);
				

			System.out.println("Deseja incluir mais um item na venda? (s/n)");
			scanner.nextLine();
			decision = scanner.nextLine();
		} while (decision.equals("s"));
		
		System.out.println("Orçamento realizado com sucesso!");
		for (Sales sale2 : budgetList) {
			System.out.println("----------------------------------------------------");
			System.out.println("SKU produto:" + sale2.getProductSKU());
			System.out.println("Quantidade: " + sale2.getProductQuantity());
			System.out.println("Total produto: " + sale2.getProductTotalSale());
			System.out.println("----------------------------------------------------");
			totalPriceBudget += sale2.getProductTotalSale();
		}
		System.out.println("Total orçamento: " + totalPriceBudget + "\n");

		
//		System.out.println("Valor total dessa venda:" + totalSalePrice);

		
	}
	

}
