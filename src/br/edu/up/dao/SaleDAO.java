package br.edu.up.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.up.dominio.Sales;

public class SaleDAO extends GenericDAO<Sales> {

	public int getLastOrder() {
//		return 0;
		int salesId = 0;
		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select saleId from sales order by saleId desc limit 1;";

			PreparedStatement executor = con.prepareStatement(sql);
			ResultSet result = executor.executeQuery();
			while (result.next()) {
				salesId = result.getInt("saleId");
				con.close();
				executor.close();
				break;
			}

		} catch (SQLException e) {
			System.out.println("Erro classe Sales.getLastOrder()");
			e.printStackTrace();
		}
		return salesId;
	}

	public double getSalePrice(int saleId) {
		double totalSalePrice = 0;

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select productTotalSale from sales where saleId = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, saleId);
			ResultSet result = executor.executeQuery();
			while (result.next()) {
				totalSalePrice += result.getDouble("productTotalSale");
			}
			con.close();
			executor.close();

		} catch (SQLException e) {
			System.out.println("Erro classe SalesDAO.getSalePrice()");
			e.printStackTrace();
		}

		return totalSalePrice;
	}

	public void getInvoice(int saleId) {

		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select \r\n" + "    p.name,\r\n" + "    s.productQuantity,\r\n" + "    s.productTotalSale\r\n"
					+ "from \r\n" + "    sales as s\r\n" + "inner join products as p on s.productSKU = p.sku\r\n"
					+ "where s.saleId = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, saleId);
			ResultSet result = executor.executeQuery();

			while (result.next()) {
				String productNameSale = result.getString("name");
				int productQuantitySale = result.getInt("productQuantity");
				double productTotalSale = result.getDouble("productTotalSale");
				System.out.println("Produto comprado: " + productNameSale + "\t Quantidade do Comprada: "
						+ productQuantitySale + "\t Valor: R$" + productTotalSale);
			}
			con.close();
			executor.close();

		} catch (SQLException e) {
			System.out.println("Erro classe SalesDAO.getInvoice()");
			e.printStackTrace();
		}
	}

	public void salesReport() {
		double totalReport = 0;
		int idAnterior = 0;
		double totalIdBuy = 0;
		Connection con;
		try {
			con = Connect.getConnection();
			String sql = "select \r\n" + "	s.saleId,\r\n" + "    p.name,\r\n" + "    s.productQuantity,\r\n"
					+ "    s.productTotalSale\r\n" + "from \r\n" + "    sales as s\r\n"
					+ "inner join products as p on s.productSKU = p.sku\r\n" + ";";
			PreparedStatement executor = con.prepareStatement(sql);
//			executor.setInt(1, saleId);
			ResultSet result = executor.executeQuery();

			while (result.next()) {
				String productNameSale = result.getString("name");
				int productQuantitySale = result.getInt("productQuantity");
				double productTotalSale = result.getDouble("productTotalSale");
				int saleId = result.getInt("saleId");
				if (saleId == idAnterior) {
					System.out.println("\t\tProduto: " + productNameSale + "\t\t Quantidade comprada: "
							+ productQuantitySale + "\t Valor: R$" + productTotalSale);
					totalReport += productTotalSale;

					totalIdBuy += productTotalSale;

					idAnterior = saleId;
				} else {
					if (idAnterior == 0) {

						System.out.println("Id compra: " + saleId + "\tProduto: " + productNameSale
								+ "\t Quantidade comprada: " + productQuantitySale + "\t Valor: R$" + productTotalSale);
						totalIdBuy = productTotalSale;
						totalReport += productTotalSale;
						idAnterior = saleId;
					}

					else {
						System.out.println("\tTotal da compra: R$" + totalIdBuy
								+ "\n-------------------------------------------------------------------------------");
						totalIdBuy = 0;

						System.out.println("Id compra: " + saleId + "\tProduto: " + productNameSale
								+ "\t Quantidade comprada: " + productQuantitySale + "\t Valor: R$" + productTotalSale);
						totalIdBuy = productTotalSale;
						totalReport += productTotalSale;
						idAnterior = saleId;
					}
				}

			}
			System.out.println("\t Total da compra: R$ " + totalIdBuy);

			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Total das vendas: R$" + totalReport + "\n");
			con.close();
			executor.close();

		} catch (SQLException e) {
			System.out.println("Erro classe SalesDAO.getInvoice()");
			e.printStackTrace();
		}

	}
}
