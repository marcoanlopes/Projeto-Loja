package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Product;

//Fazer DO/While perguntando se usuario deseja modificar mais algum item;
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

			editProduct = productDAO.getById(editProductSku);
			if (editProduct == null) {
				System.out.println("SKU inválido, favor digitar um novo SKU.");
			}
		}while(editProduct != null);

		int option;
		double editPrice;
		String editText;
		int editQuantity;
		String continuar;

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

			continuar = repeatScanner.nextLine();
		} while (continuar.equals("s"));

		productDAO.update(editProduct);



	}
}
