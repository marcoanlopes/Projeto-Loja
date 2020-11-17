package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import br.edu.up.dominio.Product;
import jdk.jfr.Description;

public class ProductDAO extends GenericDAO<Product> {

	public void findByName() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do produto:");
		String productName = scanner.nextLine();
		List<Product> productList = new ArrayList<Product>();

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select * from products where name like ? ;";

			Product product = null;
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, "%" + productName + "%");
			ResultSet result = executor.executeQuery();
			while (result.next()) {
				int sku = result.getInt("sku");
				String name = result.getString("name");
				String description = result.getString("description");
				double purchasePrice = result.getDouble("purchasePrice");
				double sellingPrice = result.getDouble("sellingPrice");
				int quantity = result.getInt("quantity");
				product = new Product(sku, name, description, purchasePrice, sellingPrice, quantity);
				productList.add(product);
			}

			System.out.println("-----------------------------------------------------------------------------------------------------");
			if (productList.size() == 0) {
				System.out.println("Produto não encontrado!");
			} else
				for (Product product2 : productList) {
					System.out.println(product2);
				}
			System.out.println("-----------------------------------------------------------------------------------------------------");

			executor.close();
			con.close();
		} catch (SQLException e1) {
			System.out.println("Erro find ProductDAO.findByName");
			e1.printStackTrace();
		}

	}

	public void getStock() {

		List<Product> productList = new ArrayList<Product>();

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select sku, name, quantity from products;";

			Product product = null;
			PreparedStatement executor = con.prepareStatement(sql);

			ResultSet result = executor.executeQuery();
			while (result.next()) {
				int sku = result.getInt("sku");
				String name = result.getString("name");
				int quantity = result.getInt("quantity");
				product = new Product(sku, name, quantity);
				productList.add(product);
			}

			System.out.println(
					"-----------------------------------------------------------------------------------------------------");

			for (Product product2 : productList) {
				System.out.println("SKU produto: " + product2.getSku() + "\tNome Produto: " + product2.getName()
						+ "\tQuantidade em estoque: " + product2.getQuantity());
			}
			System.out.println(
					"-----------------------------------------------------------------------------------------------------");

			executor.close();
			con.close();
		} catch (SQLException e1) {
			System.out.println("Erro find ProductDAO.getStock()");
			e1.printStackTrace();
		}
	}
}