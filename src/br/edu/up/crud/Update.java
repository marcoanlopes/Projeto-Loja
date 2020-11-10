package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Product;

//Fazer DO/While perguntando se usuario deseja modificar mais algum item;
//criar update do customer;

public class Update {

	public void updateProduct(List<Product> productList) {

		Scanner leitor = new Scanner(System.in);
		Scanner leitorRepetir = new Scanner(System.in);

		System.out.println("Digite o SKU para editar: ");
		int editProduct = leitor.nextInt();
		int editValor;
		double editPrice;
		String editText;
		int editQuantity;
		String continuar;
		for (Product product : productList) {
			do {
				if (product.getSku() == editProduct) {
					System.out.println("\nProduto encontrado: " + product.getName() + "\n");
					System.out.println("Digite a opção desejada:");
					System.out.println("1- Editar o nome: ");
					System.out.println("2- Editar o valor de compra: ");
					System.out.println("3- Editar o valor de venda: ");
					System.out.println("4- Editar a descrição: ");
					System.out.println("5- Editar a quantidade: ");
					editValor = leitor.nextInt();

					switch (editValor) {
					case 1: {
						for (int i = productList.size() - 1; i >= 0; i--) {
							if (editProduct == productList.get(i).getSku()) {
								System.out.println("Digite o nome desejado para o produto: ");
								leitor.nextLine();
								editText = leitor.nextLine();
								product.setName(editText);
								System.out.println("Nome alterado com sucesso!");
							}
						}
						break;
					}

					case 2: {
						for (int i = productList.size() - 1; i >= 0; i--) {
							if (editProduct == productList.get(i).getSku()) {
								System.out.println("Digite o valor de compra para o produto: ");
//							leitor.nextLine();
								editPrice = leitor.nextDouble();
								product.setBuyPrice(editPrice);
								System.out.println("Valor de compra alterado com sucesso!");
							}
						}
						break;
					}
					case 3: {
						for (int i = productList.size() - 1; i >= 0; i--) {
							if (editProduct == productList.get(i).getSku()) {
								System.out.println("Digite o valor de venda para o produto: ");
//							leitor.nextLine();
								editPrice = leitor.nextDouble();
								product.setSellPrice(editPrice);
								System.out.println("Valor de venda alterado com sucesso!");
							}
						}
						break;
					}
					case 4: {
						for (int i = productList.size() - 1; i >= 0; i--) {
							if (editProduct == productList.get(i).getSku()) {
								System.out.println("Digite a nova descrição do produto: ");
								leitor.nextLine();
								editText = leitor.nextLine();
								product.setDescription(editText);
								System.out.println("Descrição alterada com sucesso!");
							}
						}
						break;
					}
					case 5: {
						for (int i = productList.size() - 1; i >= 0; i--) {
							if (editProduct == productList.get(i).getSku()) {
								System.out.println("Digite a quantidade de produtos: ");
//							leitor.nextLine();
								editQuantity = leitor.nextInt();
								product.setQuantity(editQuantity);
								System.out.println("Quantidade de produtos alterada com sucesso!");
							}
						}
						break;
					}

					default:
						System.out.println("Não foi digitado uma opção valida, tente novamente");
					}

				}
				System.out.println("Deseja realizar outra alteração? (s/n)");
				
				continuar = leitorRepetir.nextLine();
			} while (continuar.equals("s"));

		}

	}
}
