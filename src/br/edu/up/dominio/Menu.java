package br.edu.up.dominio;

import java.util.Scanner;

public class Menu {

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
				System.out.println("Opção de criar selecionada");
				break;
			}
			case 2: {
				System.out.println("Opção de listar selecionada");
				break;
			}
			case 3: {
				System.out.println("Opção de alterar selecionada");
				break;
			}
			case 4: {
				System.out.println("Opção de deletar selecionada");
				break;
			}
			case 5: {
				System.out.println("Opção de find selecionada");
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
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu Produtos");
		Scanner leitor = new Scanner(System.in);
		int escolha = -1;
		while (escolha != 0) {
			System.out.println("Digite a operação desejada com Produtos:");
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
				System.out.println("Opção de criar selecionada");
				break;
			}
			case 2: {
				System.out.println("Opção de listar selecionada");
				break;
			}
			case 3: {
				System.out.println("Opção de alterar selecionada");
				break;
			}
			case 4: {
				System.out.println("Opção de deletar selecionada");
				break;
			}
			case 5: {
				System.out.println("Opção de find selecionada");
				break;
			}
			case 6: {
				System.out.println("opção de estoque selecionada");
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
			System.out.println("0- Voltar ao menu anterior");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1: {
				System.out.println("Opção de realizar venda selecionado");
				break;
			}
			case 2: {
				System.out.println("Opção de relatório selecionado");
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
