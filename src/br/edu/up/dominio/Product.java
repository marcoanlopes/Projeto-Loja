package br.edu.up.dominio;

import java.util.ArrayList;
import java.util.List;

public class Product {
	public List<Product> productList = new ArrayList<Product>();

	private int sku; // PRIMARY KEY
	private String name;
	private String description;
	private double buyPrice;
	private double sellPrice;
	private int quantity;
	
	public Product() {
		
	}
	public Product(int sku, String name, String description, double buyPrice, double sellPrice, int quantity) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.quantity = quantity;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}