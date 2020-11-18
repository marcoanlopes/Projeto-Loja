package br.edu.up.sistema;

//import java.util.ArrayList;
import java.util.List;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Menu;
import br.edu.up.dominio.Product;

public class Programa {

	public static void main(String[] args) {
//		ProductDAO produtodao = new ProductDAO();
//		List<Product> productList = produtodao.list();

		Menu.mainMenu();

		System.out.println("Programa Finalizado");
	}
}
