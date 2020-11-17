package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CustomerDAO;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Customer;
import br.edu.up.dominio.Product;


//criar update do customer;

public class Update {

	public void updateProduct() {

		Scanner scanner = new Scanner(System.in);
		Scanner repeatScanner = new Scanner(System.in);
		Product editProduct = null;
		ProductDAO productDAO = new ProductDAO();

		do {
			System.out.println("Digite o SKU para editar: ");
			int editProductSku = scanner.nextInt();

			editProduct = productDAO.findById(editProductSku);
			if (editProduct == null) {
				System.out.println("SKU inválido, favor digitar um novo SKU.");
			}
		}while(editProduct == null);

		int option;
		double editPrice;
		String editText;
		int editQuantity;
		String decision;

		do {

			System.out.println("\nProduto encontrado: " + editProduct.getName() + "\n");
			System.out.println("Digite a opção desejada:");
			System.out.println("1- Editar o nome: ");
			System.out.println("2- Editar o valor de compra: ");
			System.out.println("3- Editar o valor de venda: ");
			System.out.println("4- Editar a descrição: ");
			System.out.println("5- Editar a quantidade: ");
			option = scanner.nextInt();

			switch (option) {
			case 1: {


				System.out.println("Digite o nome desejado para o produto: ");
				scanner.nextLine();
				editText = scanner.nextLine();
				editProduct.setName(editText);
				System.out.println("Nome alterado com sucesso!");

				break;
			}

			case 2: {
				System.out.println("Digite o valor de compra para o produto: ");
				//							scanner.nextLine();
				editPrice = scanner.nextDouble();
				editProduct.setPurchasePrice(editPrice);
				System.out.println("Valor de compra alterado com sucesso!");
				break;
			}
			case 3: {
				System.out.println("Digite o valor de venda para o produto: ");
				//							scanner.nextLine();
				editPrice = scanner.nextDouble();
				editProduct.setSellingPrice(editPrice);
				System.out.println("Valor de venda alterado com sucesso!");
				break;
			}
			case 4: {
				System.out.println("Digite a nova descrição do produto: ");
				scanner.nextLine();
				editText = scanner.nextLine();
				editProduct.setDescription(editText);
				System.out.println("Descrição alterada com sucesso!");
				break;
			}
			case 5: {
				System.out.println("Digite a quantidade de produtos: ");
				//						scanner.nextLine();
				editQuantity = scanner.nextInt();
				editProduct.setQuantity(editQuantity);
				System.out.println("Quantidade de produtos alterada com sucesso!");
				break;
			}

			default:
				System.out.println("Não foi digitado uma opção valida, tente novamente");
			}

			System.out.println("Deseja realizar outra alteração? (s/n)");

			decision = repeatScanner.nextLine();
		} while (decision.equals("s"));

		productDAO.updateDAO(editProduct);
	}
	
	
	
	
	public void updateCustomer() {

		Scanner scanner = new Scanner(System.in);
		Scanner repeatScanner = new Scanner(System.in);
		Customer editCustomer = null;
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.findCustomerByName();
		
		do {
			System.out.println("Selecione o ID do cliente para atualizar: ");
			int editCustomerId = scanner.nextInt();

			editCustomer = customerDAO.findById(editCustomerId);
			if (editCustomer == null) {
				System.out.println("Id cliente inválido, favor digitar um novo nome.");
			}
		}while(editCustomer == null);

		int option;
		String editCPF;
		String editCustomerName;
		String adress;
		String phoneType;
		String phoneNumber;
		String email;
		String note;
		String decision;

		do {

			System.out.println("\nCliente encontrado: " + editCustomer.getCustomerName()+ "\n");
			System.out.println("Digite a opção desejada:");
			System.out.println("1- Editar o nome: ");
			System.out.println("2- Editar o CPF: ");
			System.out.println("3- Editar o endereço: ");
			System.out.println("4- Editar o tipo do telefone: ");
			System.out.println("5- Editar o telefone: ");
			System.out.println("6- Editar o email: ");
			System.out.println("5- Editar a observação: ");
			option = scanner.nextInt();

			switch (option) {
			case 1: {

				System.out.println("Digite o nome desejado para o cliente: ");
				scanner.nextLine();
				editCustomerName = scanner.nextLine();
				editCustomer.setCustomerName(editCustomerName);
				System.out.println("Nome do cliente alterado com sucesso!");
				break;
			}

			case 2: {
				System.out.println("Digite o novo CPF: ");
				scanner.nextLine();
				editCPF = scanner.nextLine();
				editCustomer.setCpf(editCPF);
				System.out.println("CPF alterado com sucesso!");
				break;
			}
			
			case 3: {
				System.out.println("Digite o novo endereço do cliente: ");
				scanner.nextLine();
				adress = scanner.nextLine();
				editCustomer.setAdress(adress);
				System.out.println("Endereço alterado com sucesso!");
				break;
			}
			
			case 4: {
				System.out.println("Digite o novo tipo do telefone: ");
				scanner.nextLine();
				phoneType = scanner.nextLine();
				editCustomer.setPhoneType(phoneType);
				System.out.println("Tipo do telefone alterado com sucesso!");
				break;
			}
			
			case 5: {
				System.out.println("Digite o novo telefone: ");
				scanner.nextLine();
				phoneNumber = scanner.nextLine();
				editCustomer.setPhoneNumber(phoneNumber);
				System.out.println("Telefone alterado com sucesso!");
				break;
			}
			
			case 6: {
				System.out.println("Digite o novo email do cliente: ");
				scanner.nextLine();
				email = scanner.nextLine();
				editCustomer.setEmail(email);
				System.out.println("Email alterado com sucesso!");
				break;
			}
			
			case 7: {
				System.out.println("Digite uma observação: ");
				scanner.nextLine();
				note = scanner.nextLine();
				editCustomer.setNote(note);
				System.out.println("Nota alterada com sucesso!");
				break;
			}

			default:
				System.out.println("Não foi digitado uma opção valida, tente novamente");
			}

			System.out.println("Deseja realizar outra alteração? (s/n)");

			decision = repeatScanner.nextLine();
		} while (decision.equals("s"));

		customerDAO.updateDAO(editCustomer);
	}
}
