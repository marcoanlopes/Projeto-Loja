package br.edu.up.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import br.edu.up.dominio.Product;

import br.edu.up.crud.Create;
import br.edu.up.crud.Delete;
import br.edu.up.crud.Read;
import br.edu.up.crud.Update;

public class Menu {
	static Create criar = new Create();
	static Read listar = new Read();
	static Update atualizar = new Update();
	static Delete deletar = new Delete();
	static List<Product> productList = new ArrayList<>();

//	public 
//	public List <Customer> customerList = new ArrayList<>();
	public static void mainMenu() {
		
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		System.out.println("Seja bem vindo ao menu de sua loja!");
		while (escolha != 0) {

			System.out.println("Digite a op��o desejada:");
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
				productsMenu(productList);
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
				System.out.println("Esse n�o � um n�mero v�lido, por favor tente novamente.\n");
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
			System.out.println("Digite a opera��o desejada com Clientes:");
			System.out.println("1- Cadastrar (create)");
			System.out.println("2- Listar (read)");
			System.out.println("3- Alterar (update)");
			System.out.println("4- Deletar (delete)");
			System.out.println("5- Procurar (find)");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				System.out.println("Op��o de criar selecionada");
				break;
			}
			case 2: {
				System.out.println("Op��o de listar selecionada");
				break;
			}
			case 3: {
				System.out.println("Op��o de alterar selecionada");
				break;
			}
			case 4: {
				System.out.println("Op��o de deletar selecionada");
				break;
			}
			case 5: {
				System.out.println("Op��o de find selecionada");
				break;
			}
			case 0: {

				break;
			}

			default:
				System.out.println("Esse n�o � um n�mero v�lido, por favor tente novamente.\n");
				break;
			}

		}

	}

	public static void productsMenu(List <Product> productList) {
//		List <Product> productList = new ArrayList<>();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu Produtos");
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		while (escolha != 0) {
			System.out.println("Digite a opera��o desejada com Produtos:");
			System.out.println("1- Cadastrar (create)");
			System.out.println("2- Listar (read)");
			System.out.println("3- Alterar (update)");
			System.out.println("4- Deletar (delete)");
			System.out.println("5- Procurar (find)");
			System.out.println("6- ------------Estoque-----------");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {		
				criar.createProduct(productList);
				break;
			}
			case 2: {
				listar.readProduct(productList);
				break;
			}
			case 3: {
				atualizar.updateProduct(productList);
				break;
			}
			case 4: {
				deletar.deleteProduct(productList);
				break;
			}
			case 5: {
				System.out.println("Op��o de find selecionada");
				break;
			}
			case 6: {
				System.out.println("op��o de estoque selecionada");
				break;
			}

			case 0: {

				break;
			}

			default:
				System.out.println("Esse n�o � um n�mero v�lido, por favor tente novamente.\n");
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
			System.out.println("Digite a opera��o desejada com Vendas:");
			System.out.println("1- Realizar venda");
			System.out.println("2- Relat�rio");
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				System.out.println("Op��o de realizar venda selecionado");
				break;
			}
			case 2: {
				System.out.println("Op��o de relat�rio selecionado");
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Esse n�o � um n�mero v�lido, por favor tente novamente.\n");
				break;
			}

		}
	}
}
