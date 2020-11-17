package br.edu.up.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Customer;
import br.edu.up.dominio.Product;

//need to fix if else customersize;

public class CustomerDAO extends GenericDAO<Customer> {

	public void findCustomerByName() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do cliente: ");
		String customerName = scanner.nextLine();
		List<Customer> customerList = new ArrayList<Customer>();

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select * from customers where customerName like ? ;";

			Customer customer = null;
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, "%" + customerName + "%");
			ResultSet result = executor.executeQuery();
			while (result.next()) {
				int customerId = result.getInt("customerId");
				String name = result.getString("customerName");
				String cpf = result.getString("cpf");
				String adress = result.getString("adress");
				String phoneType = result.getString("phoneType");
				String phoneNumber = result.getString("phoneNumber");
				String email = result.getString("email");
				String note = result.getString("note");
				customer = new Customer(customerId, name, cpf, adress, phoneType, phoneNumber, email, note);
				customerList.add(customer);
			}

			System.out.println(
					"-----------------------------------------------------------------------------------------------------");
			if (customerList.size() == 0) {
				System.out.println("Cliente não encontrado!");
			} else
				for (Customer customer2 : customerList) {
					System.out.println(customer2);
				}
			System.out.println(
					"-----------------------------------------------------------------------------------------------------");

			executor.close();
			con.close();
		} catch (SQLException e1) {
			System.out.println("Erro find CustomerDAO.findByCustomerName");
			e1.printStackTrace();
		}
	}

	public void setCustomer(int salesId) {
		Scanner scanner = new Scanner(System.in);
//		CustomerDAO customerDAO = new CustomerDAO();
		findCustomerByName();
		System.out.println("Digite o id do cliente para vincular: ");
		
		int idCustomer = scanner.nextInt();
//		customerDAO.findById(idCustomer);
		

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "update sales set customerId = ? where saleId = ?;"; 
					
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, idCustomer);
			executor.setInt(2, salesId);
			
			executor.executeUpdate();
			executor.close();
			con.close();
			
		}
		catch (SQLException e1) {
			System.out.println("Erro find CustomerDAO.setCustomer()");
			e1.printStackTrace();
		}

		
	}
	
}