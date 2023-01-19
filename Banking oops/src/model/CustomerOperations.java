package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CustomerOperations {
	static HashMap<Integer,Customer> customers=new HashMap<Integer,Customer>();
	
	public void initializeDetails() {
		customers.put(11,new Customer(11, 11011, "jaga",10000,"AAbb33"));
		customers.put(22,new Customer(22, 22022, "rajesh",10000,"AAbb33"));
		customers.put(33,new Customer(33, 33033, "yogesh",10000,"AAbb33"));
		customers.put(44,new Customer(44, 44044, "vicky",10000,"AAbb33"));
		customers.put(55,new Customer(55, 55055, "bharath",10000,"AAbb33"));
		customers.put(66,new Customer(66, 66066, "ben",10000,"AAbb33"));
		customers.put(77,new Customer(77, 77077, "kick",10000,"AAbb33"));
		customers.put(88,new Customer(88, 88088, "jhon",10000,"AAbb33"));
		customers.put(99,new Customer(99, 99099, "mosh",10000,"AAbb33"));
		customers.put(110,new Customer(110, 110110, "kunal",10000,"AAbb33"));
		customers.put(121,new Customer(121, 121121, "ben",10000,"AAbb33"));
		customers.put(132,new Customer(132, 132132, "kick",10000,"AAbb33"));
		customers.put(143,new Customer(143, 143143, "jhon",10000,"AAbb33"));
		customers.put(154,new Customer(154, 154154, "mosh",10000,"AAbb33"));
		customers.put(165,new Customer(165, 165165, "kunal",10000,"AAbb33"));
	}
	
	private int newCustid() {
		int last_customer_id=customers.size()+1;
		int new_customer_id=last_customer_id*11;
		return new_customer_id;
	}
	private int newAccNo() {
		int last_customer_id=newCustid();
		int new_acc_no=(last_customer_id*1000)+last_customer_id;
		return new_acc_no;
	}
	 
	private void addCustomer() {
		Password password=new Password();
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter name");
		String name=scan.next();
		String pass=password.enterPass();
		customers.put(newCustid(),new Customer(newCustid(),newAccNo(),name,10000,pass));
	}
	
	
	
	 private Comparator<Customer> balence_comparator = new Comparator<Customer>() {
		 @Override
		 public int compare(Customer customer_1, Customer customer_2) {
			if(customer_1.getBalence()==customer_2.getBalence()) {
				return 0;
			}
			else if(customer_1.getBalence()<customer_2.getBalence()) {
				return -1;
			}
			else {
				return 1;
			}
		}
	 }; 
		
	 public static void main(String[] args) {
		 CustomerOperations co=new CustomerOperations();
		 co.initializeDetails() ;
		System.out.println(co.newCustid()) ;
		System.out.println(co.newAccNo()) ;
	}
}
