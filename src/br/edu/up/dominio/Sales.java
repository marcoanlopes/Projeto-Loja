package br.edu.up.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.edu.up.dao.Connect;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dao.SaleDAO;

@Entity
@Table(name = "sales")
@TableGenerator(name = "sale_generator", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "sales", initialValue = 1, allocationSize = 1)

public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sale_generator")
	private int id;
	private int saleId;
	private int productSKU;
	private int productQuantity;
	private double productTotalSale;
	private int customerId;

	public Sales() {

	}

//	public Sales(int id, int orderId, int productSKU, int productQuantity, double productTotalSale) {
//		this.id = id;
//		this.saleId = saleId;
//		this.productSKU = productSKU;
//		this.productQuantity = productQuantity;
//		this.productTotalSale = productTotalSale;
//		
//	}
	public Sales(int salesId, int productSKU, int productQuantity, double productTotalSale, int customerId) {
		this.saleId = salesId;
		this.productSKU = productSKU;
		this.productQuantity = productQuantity;
		this.productTotalSale = productTotalSale;
		this.customerId = customerId;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(int productSKU) {
		this.productSKU = productSKU;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductTotalSale() {
		return productTotalSale;
	}

	public void setProductTotalSale(double productTotalSale) {
		this.productTotalSale = productTotalSale;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

//	@Override
//	public String toString() {
//		
//		 + productSKU + productQuantity + productTotalSale;
//	}

}
