package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Product;

public class Update {

	public void updateProduct(List<Product> productList) {

		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o SKU para editar");
		int editProduct = leitor.nextInt();

		for (Product product : productList) {
			if (product.getSku() == editProduct) {
				System.out.println("Produto encontrado: " + product.getName());
				
				System.out.println("Digite a opção desejada:");
				editProduct = leitor.nextInt();
				System.out.println("1- Editar o nome ");
				System.out.println("2- Editar o valor de compra ");
				System.out.println("3- Editar o valor de venda ");
				System.out.println("4- Editar a descrição ");
				System.out.println("5- Editar a quantidade ");
				
				switch (editProduct) {
				case 1: {
//					System.out.println("Digite o novo nome: ");
//					String editProductName = leitor.nextLine();
//					product.getName() = editProductName;
									}
				default:
					System.out.println("Não foi digitado uma opção valida, tente novamente");
				}
			
			}
			
	}

}
}
