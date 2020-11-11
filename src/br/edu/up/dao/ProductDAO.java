package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.dominio.Product;
import jdk.jfr.Description;

public class ProductDAO implements DAO<Product> {

	@Override
	public Product create(Product entity) {
		// Arrumar o try/catch
		Connection con = getConnection();
		
		String sql = "insert into Products (name, description, PurchasePrice, sellPrice, quantity) values (?, ?, ?, ?, ?);";
		try {
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, entity.getName());
			executor.setString(2, entity.getDescription());
			executor.setDouble(3, entity.getPurchasePrice());
			executor.setDouble(4, entity.getSellingPrice());
			executor.setInt(5, entity.getQuantity());			

			executor.executeUpdate();

			executor.close();
			con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product update(Product entity) {
		// Terminar o try/catch
		Connection con = getConnection();
		
		String sql = "update Products set name = ?, description = ?, PurchasePrice = ?, sellPrice = ?, quantity = ? where sku = ?;";
		try {
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, entity.getName());
			executor.setString(2, entity.getDescription());
			executor.setDouble(3, entity.getPurchasePrice());
			executor.setDouble(4, entity.getSellingPrice());
			executor.setInt(5, entity.getQuantity());
			executor.setInt(6, entity.getSku());
			
			executor.executeUpdate();
			
			executor.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		String sql = "select * from Products where sku = ?;";

		Product product = null;
	
		try {
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, id);
			ResultSet result = executor.executeQuery();
			while(result.next()) {
				int sku = result.getInt("sku");
				String name = result.getString("name");
				String description = result.getNString("description");
				double PurchasePrice = result.getDouble("PurchasePrice");
				double sellPrice = result.getDouble("sellPrice");
				int quantity = result.getInt("quantity");
				product = new Product(sku, name, description, PurchasePrice, sellPrice, quantity);
				
				break;
			}
			
			executor.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public List<Product> getAll() {
		// Terminar o try/catch
		Connection con = getConnection();
		List<Product> productList = new ArrayList<Product>();
		
		try {
			Statement executor = con.createStatement();
			String sql = "select * from Products";
			ResultSet result = executor.executeQuery(sql);
			
			while (result.next()) {
				int sku = result.getInt("sku");
				String name = result.getString("name");
				String description = result.getNString("description");
				double PurchasePrice = result.getDouble("PurchasePrice");
				double sellPrice = result.getDouble("sellPrice");
				int quantity = result.getInt("quantity");
				
				Product product = new Product(sku, name, description, PurchasePrice, sellPrice, quantity);
				
				productList.add(product);
			}
			
			executor.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		String sql = "delete from Products where sku = ?;";
		try {
			PreparedStatement executor = con.prepareStatement(sql);
			
			executor.setInt(1, id);
			
			executor.executeUpdate();
			
			executor.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Connection getConnection() {
		// Arrumar a URL do Banco de Dados / Arrumar o try/catch
		String url = "";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
