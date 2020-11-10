package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Product;

//Criar um delete customer;

public class Delete {

	public void deleteProduct(List<Product> productList) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o SKU: ");
		int leitorSKU = leitor.nextInt();

		for (int i = productList.size() - 1; i >= 0; i--) {
			if (leitorSKU == productList.get(i).getSku()) {
				System.out.println("Produto: " + productList.get(i).getName() + " encontrado deseja removê-lo? (s/n)");
				leitor.nextLine();
				String decisao = leitor.nextLine();
				if (decisao.equals("s") || decisao.equals("S")) {
					System.out.println("Produto: " + productList.get(i).getName() + "\nRemovido com sucesso!");			
					productList.remove(i);
				}
				else {
					System.out.println("Voltando ao menu anterior..");
					break;
				}
				
			}

		}
	}

}
