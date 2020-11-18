package br.edu.up.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import br.edu.up.dominio.Product;

import br.edu.up.crud.Create;
import br.edu.up.crud.Delete;
import br.edu.up.crud.Read;
import br.edu.up.crud.Update;
import br.edu.up.dao.CustomerDAO;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dao.SaleDAO;

public class Menu {
	static Create criar = new Create();
	static Read listar = new Read();
	static Update atualizar = new Update();
	static Delete deletar = new Delete();
	static ProductDAO productDAO = new ProductDAO();
	static Sales sales = new Sales();
	static CustomerDAO customerDAO = new CustomerDAO();
	static SaleDAO saleDAO = new SaleDAO();

//	static List<Product> productList = new ArrayList<>();

//	public 
//	public List <Customer> customerList = new ArrayList<>();
	public static void mainMenu() {
		
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		System.out.println("Seja bem vindo ao menu de sua loja!");
		while (escolha != 0) {

			System.out.println("Digite a opção desejada:");
			System.out.println("1- Clientes");
			System.out.println("2- Produtos");
			System.out.println("3- Vendas");
			System.out.println("0- Sair");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				customersMenu();
				break;
			}
			case 2: {
				productsMenu();
				break;
			}
			case 3: {
				salesMenu();
				break;
			}
			case 0: {
				System.out.println("Saindo...");
				escolha = 0;
				break;
			}
			default:
				System.out.println("Esse não é um número válido, por favor tente novamente.\n");
				break;
			}

		}

//		leitor.close();
	}

	public static void customersMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu Clientes");
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		while (escolha != 0) {
			System.out.println("Digite a operação desejada com Clientes:");
			System.out.println("1- Cadastrar (create)");
			System.out.println("2- Listar (read)");
			System.out.println("3- Alterar (update)");
			System.out.println("4- Deletar (delete)");
			System.out.println("5- Procurar (find)");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				criar.createCustomer();
				break;
			}
			case 2: {
				listar.readCustomer();
				break;
			}
			case 3: {
				atualizar.updateCustomer();
				break;
			}
			case 4: {
				deletar.deleteCustomer();
				break;
			}
			case 5: {
				customerDAO.findCustomerByName();
				break;
			}
			case 0: {

				break;
			}

			default:
				System.out.println("Esse não é um número válido, por favor tente novamente.\n");
				break;
			}

		}

	}

	public static void productsMenu() {
//		List <Product> productList = new ArrayList<>();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu Produtos");
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		while (escolha != 0) {
			System.out.println("Digite a operação desejada com Produtos:");
			System.out.println("1- Cadastrar (Create)");
			System.out.println("2- Listar (Read)");
			System.out.println("3- Alterar (Update)");
			System.out.println("4- Deletar (Delete)");
			System.out.println("5- Procurar (Find)");
			System.out.println("6- Estoque (Stock)");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {		
				criar.createProduct();
				break;
			}
			case 2: {
				listar.readProduct();
				break;
			}
			case 3: {
				atualizar.updateProduct();
				break;
			}
			case 4: {
				deletar.deleteProduct();
				break;
			}
			case 5: {
				productDAO.findByName();
				break;
			}
			case 6: {
				productDAO.getStock();
				break;
			}

			case 0: {
				break;
			}

			default:
				System.out.println("Esse não é um número válido, por favor tente novamente.\n");
				break;
			}

		}
	}

	public static void salesMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu Vendas");
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		while (escolha != 0) {
			System.out.println("Digite a operação desejada com Vendas:");
			System.out.println("1- Realizar venda");
			System.out.println("2- Relatório");
			System.out.println("3- Realizar Orçamento");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				criar.sellProduct();
				break;
			}
			case 2: {
				saleDAO.salesReport();
				break;
			}
			case 3: {
				listar.getBudget();
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Esse não é um número válido, por favor tente novamente.\n");
				break;
			}

		}
	}
}
