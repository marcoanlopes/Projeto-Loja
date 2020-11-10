package br.edu.up.crud;

import java.util.List;

import br.edu.up.dominio.Product;

//private int sku; // PRIMARY KEY
//private String name;
//private String description;
//private double buyPrice;
//private double sellPrice;
//private int quantity;

public class Read {

	public void readProduct(List<Product> productList) {
		for (Product product : productList) {
			System.out.println("SKU: " + product.getSku() + "\tNome: " + product.getName() + "\tPreço de compra: "
					+ product.getBuyPrice() + "\tPreço de venda: " + product.getSellPrice() + "\tDescrição: "
					+ product.getDescription() + "\tQuantidade: " + product.getQuantity());
		}
	}

}
