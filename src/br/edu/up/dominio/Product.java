package br.edu.up.dominio;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "products")
@TableGenerator(
		name = "sku_generator",
		table = "sqlite_sequence",
		pkColumnName = "name",
		valueColumnName = "seq",
		pkColumnValue = "products",
		initialValue = 1,
		allocationSize = 1
		)

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator="sku_generator")
	private int sku;
	private String name;
	private String description;
	private double purchasePrice;
	private double sellingPrice;
	private int quantity;

	public Product() {

	}

	public Product(int sku, String name, String description, double purchasePrice, double sellingPrice, int quantity) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}

	public Product(String name, String description, double purchasePrice, double sellingPrice, int quantity) {
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}
	
	public Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	public Product(int sku, String name, int quantity) {
		this.sku = sku;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product(int sku, int quantity) {
		this.sku = sku;
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

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "SKU produto: " + sku + "\t Nome produto: " + name + "\tPreço pago: " + purchasePrice + "\tPreço venda: "
				+ sellingPrice + "\tQuantidade estoque: " + quantity + "\tDescrição: " + description;
	}
}