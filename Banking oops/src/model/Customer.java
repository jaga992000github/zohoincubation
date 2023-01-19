package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer{
	private int cust_id;
	private int acc_no;
	private String name;
	private int balence;
	private String enc_pass;
	
	
	public Customer(int cust_id, int acc_no, String name, int balence, String enc_pass) {
		super();
		this.cust_id = cust_id;
		this.acc_no = acc_no;
		this.name = name;
		this.balence = balence;
		this.enc_pass = enc_pass;
	}
	public Customer() {
		
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalence() {
		return balence;
	}
	public void setBalence(int balence) {
		this.balence = balence;
	}
	public String getEnc_pass() {
		return enc_pass;
	}
	public void setEnc_pass(String enc_pass) {
		this.enc_pass = enc_pass;
	}

	       
	@Override
	public String toString() {
		
		return"\nCustomer ID:"+this.cust_id
			+ "\nAccount No:"+this.acc_no
			+ "\nName:"+this.name
			+ "\nBalence:"+this.balence
			+ "\nPassword:"+this.enc_pass+"\n-------------------------";
	}
	public static void main(String[] args) {
		CustomerOperations co=new CustomerOperations();
		
		Customer cust =new Customer();
		
		
	}
}
