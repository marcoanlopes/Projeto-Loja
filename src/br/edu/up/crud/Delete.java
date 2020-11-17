package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.CustomerDAO;
import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Customer;
import br.edu.up.dominio.Product;

//Criar um delete customer;

public class Delete {

	public void deleteProduct() {
		Scanner scanner = new Scanner(System.in);
		ProductDAO productDAO = new ProductDAO();
		Product deleteProduct = null;
		int skuScanner = 0;
		
		do {
			
			System.out.println("Digite o SKU: ");
			skuScanner = scanner.nextInt();
			deleteProduct = productDAO.findById(skuScanner);
			if(deleteProduct == null) {
				System.out.println("SKU inválido, favor digitar um novo SKU.");
			}			
			
		}while(deleteProduct == null);
		
		
		System.out.println("Produto: " + deleteProduct.getName() + " encontrado deseja removê-lo? (s/n)");
		scanner.nextLine();
		String decision = scanner.nextLine();
		if (decision.equals("s") || decision.equals("S")) {
			System.out.println("Produto: " + deleteProduct.getName() + "\nRemovido com sucesso!");			
			productDAO.erase(skuScanner);
		}
		else {
			System.out.println("Voltando ao menu anterior..");
		}
		
	}

	public void deleteCustomer() {
		Scanner scanner = new Scanner(System.in);
		CustomerDAO customerDAO = new CustomerDAO();
		Customer deleteCustomer = null;
		int customerScanner = 0;
		customerDAO.findCustomerByName();
		do {
			
			System.out.println("Digite o id do cliente para deletar: ");
			customerScanner = scanner.nextInt();
			deleteCustomer = customerDAO.findById(customerScanner);
			if(deleteCustomer == null) {
				System.out.println("ID cliente inválido, favor digitar um novo customer.");
			}			
			
		}while(deleteCustomer == null);
		
		
		System.out.println("Cliente: " + deleteCustomer.getCustomerName() + " encontrado deseja removê-lo? (s/n)");
		scanner.nextLine();
		String decision = scanner.nextLine();
		if (decision.equals("s") || decision.equals("S")) {
			System.out.println("Produto: " + deleteCustomer.getCustomerName() + "\nRemovido com sucesso!");			
			customerDAO.erase(customerScanner);
		}
		else {
			System.out.println("Voltando ao menu anterior..");
		}
		
	}
	

}
