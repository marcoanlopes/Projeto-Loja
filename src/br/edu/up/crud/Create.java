package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Product;


//criar um create Customer;

public class Create {

	public void createProduct() {
		
		Product product = new Product();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do produto:");
		scanner.nextLine();
		product.setName(scanner.nextLine());
		System.out.println("Digite a descrição do produto");
		product.setDescription(scanner.nextLine());
		System.out.println("Digite o preco pago pelo produto");
		product.setPurchasePrice(scanner.nextDouble());
		System.out.println("Digite o preco de venda");
		product.setSellingPrice(scanner.nextDouble());
		System.out.println("Digite a quantidade comprada");
		product.setQuantity(scanner.nextInt());
		
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.create(product);
		
	}
	
	
	public void createCustomer() {
		
	}
}
