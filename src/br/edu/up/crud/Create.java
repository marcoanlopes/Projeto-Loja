package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Product;

public class Create {

	public void createProduct(List<Product> productList) {
		
		Product produto = new Product();
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o SKU do produto:");
		produto.setSku(leitor.nextInt());
		System.out.println("Digite o nome do produto:");
		leitor.nextLine();
		produto.setName(leitor.nextLine());
		System.out.println("Digite a descrição do produto");
		produto.setDescription(leitor.nextLine());
		System.out.println("Digite o preco pago pelo produto");
		produto.setBuyPrice(leitor.nextDouble());
		System.out.println("Digite o preco de venda");
		produto.setSellPrice(leitor.nextDouble());
		System.out.println("Digite a quantidade comprada");
		produto.setQuantity(leitor.nextInt());
		
		productList.add(produto);
		
	}
	
	
	public void createCustomer() {
		
	}
}
