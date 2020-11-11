package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.dominio.Product;

public class ProductDAO implements DAO<Product> {

	@Override
	public Product create(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
				double buyPrice = result.getDouble("buyPrice");
				double sellPrice = result.getDouble("sellPrice");
				int quantity = result.getInt("quantity");
				
				Product product = new Product(sku, name, description, buyPrice, sellPrice, quantity);
				
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
