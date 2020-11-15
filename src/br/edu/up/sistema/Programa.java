package br.edu.up.sistema;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Menu;
import br.edu.up.dominio.Product;


public class Programa {

	
	public static void main(String[] args) {
		ProductDAO produtodao = new ProductDAO();
//		Product produto = new Product("novo nome", "nova descrição", 10, 15, 3);
//		produtodao.save(produto);
//		
		List<Product> productList = produtodao.list();
		
		
	
		
//		List <Product> productList = new ArrayList<Product>();
		
		Menu.mainMenu(productList);
		
		
//		
//		
//		for (Product product : productList) {
//			System.out.println(product);
//		}
		
		System.out.println("Programa Finalizado");
	}
}
