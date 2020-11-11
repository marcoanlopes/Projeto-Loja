package br.edu.up.crud;

import java.util.List;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Product;

//Criar um readCustomer;

public class Read {

	public void readProduct() {
		ProductDAO productDAO = new ProductDAO();
		List<Product> productList = productDAO.getAll();
		for (Product product : productList) {
			System.out.println("SKU: " + product.getSku() + "\tNome: " + product.getName() + "\tPre�o de compra: "
					+ product.getPurchasePrice() + "\tPre�o de venda: " + product.getSellingPrice() + "\tDescri��o: "
					+ product.getDescription() + "\tQuantidade: " + product.getQuantity());
		}
	}

}
