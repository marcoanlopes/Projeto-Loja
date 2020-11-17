package br.edu.up.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "customers")
@TableGenerator(name = "customer_generator", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "customers", initialValue = 1, allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_generator")
	private int customerId;
	private String cpf;
	private String customerName;
	private String adress;
	private String phoneType;
	private String phoneNumber;
	private String email;
	private String note;

	public Customer() {
	}

	public Customer(int customerId, String customerName, String cpf, String adress, 
			String phoneType, String phoneNumber, String email, String note) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.cpf = cpf;
		this.adress = adress;
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {

		return "ID Cliente: " + customerId + "\t Nome do Cliente:" + customerName + "\t Endereço: " + adress
				+ "\t Tipo do telefone: " + phoneType + "\t Número Telefone: " + phoneNumber + "\t Email: " + email
				+ "\t Observações: " + note;
	}

}