package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.ProductDAO;
import br.edu.up.dominio.Product;

//Criar um delete customer;

public class Delete {

	public void deleteProduct(List<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		ProductDAO productDAO = new ProductDAO();
		Product deleteProduct = null;
		int skuScanner = 0;
		
		do {
			
			System.out.println("Digite o SKU: ");
			skuScanner = scanner.nextInt();
			deleteProduct = productDAO.getById(skuScanner);
			if(deleteProduct == null) {
				System.out.println("SKU inválido, favor digitar um novo SKU.");
			}			
			
		}while(deleteProduct == null);
		
		
		System.out.println("Produto: " + deleteProduct.getName() + " encontrado deseja removê-lo? (s/n)");
		scanner.nextLine();
		String decision = scanner.nextLine();
		if (decision.equals("s") || decision.equals("S")) {
			System.out.println("Produto: " + deleteProduct.getName() + "\nRemovido com sucesso!");			
			productDAO.delete(skuScanner);
		}
		else {
			System.out.println("Voltando ao menu anterior..");
		}
		
	}

		
	

}
