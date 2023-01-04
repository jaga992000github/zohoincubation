package controller_and_view;
import java.sql.SQLException;
import java.util.*;

import model.AdminOperationsDB;
import model.CRUD;
public class AdminOperations implements Operations {
	static Scanner scan =new Scanner(System.in);
	static AdminOperationsDB aodb=new AdminOperationsDB();
	
	@Override
	public void operate() throws ClassNotFoundException, SQLException {
		AdminOperations ao=new AdminOperations();
		String num="";int n=0;
		while(true) {
			System.out.println("1->View/Remove Buyers"
					   + "\n2->View/Remove Sellers"
					   + "\n3->View/Remove lands"
					   + "\n4->View/Remove houses"
					   + "\n5->view/Remove Mails"
					   + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				operate();
		    }
			if(n==1) {
				ao.VOR_Buyers();
			}
			else if(n==2){
				ao.VOR_Sellers();
			}
			else if(n==3){
				ao.VOR_Land();
			}
			else if(n==4){
				ao.VOR_House();
			}
			else if(n==5){
				
			}
			else if(n==0){
				break;
			}
			else {
				System.out.println("please select given numbers only");
			}
		}
		
	}
	private void VOR_Land() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->deleate land"
							+ "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
		    	VOR_Land();
		    }
			if(n==1) {
				String num1="";int land_id=0;
				ArrayList<Integer> prop_ids=aodb.readLand();
				if(prop_ids.size()==0) {
					System.out.println("there is no property exists");
					break;
				}
				while(true) {
					while(true) {
						System.out.println("Select land id"
								+ "\npress 0 to cancel");
						num1=scan.next();
						try {
							land_id=Integer.parseInt(num1);
							break;
						}
					    catch(NumberFormatException e) {
					    	System.out.println("please enter numbers only");
					    }
					}
					if(land_id==0) {
						break;
					}
				if(prop_ids.contains(land_id)) {
					CRUD.deleteRow(land_id,"land");
					System.out.println("this land is Deleated Sucessfully");
					break;
				}
				else {
					System.out.println("please enter given Land ID only");
				}
				}
			}
			if(n==0) {
				break;
			}
		}
	}
	private void VOR_House() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->deleate house"
							+ "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
		    	VOR_House();
		    }
			if(n==1) {
				String num1="";int house_id=0;
				ArrayList<Integer> prop_ids=aodb.readHouse();
				if(prop_ids.size()==0) {
					System.out.println("there is no property exists");
					break;
				}
				while(true) {
					while(true) {
						System.out.println("Select house id"
								+ "\npress 0 to cancel");
						num1=scan.next();
						try {
							house_id=Integer.parseInt(num1);
							break;
						}
					    catch(NumberFormatException e) {
					    	System.out.println("please enter numbers only");
					    }
					}
					if(house_id==0) {
						break;
					}
				if(prop_ids.contains(house_id)) {
					CRUD.deleteRow(house_id,"house");
					System.out.println("this house is Deleated Sucessfully");
					break;
				}
				else {
					System.out.println("please enter given house ID only");
				}
				}
			}
			if(n==0) {
				break;
			}
		}
	}
	
	private void VOR_Buyers() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->deleate buyers"
							+ "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
		    	VOR_Buyers();
		    }
			if(n==1) {
				String num1="";int buyer_id=0;
				ArrayList<Integer> user_ids=aodb.readHouse();
				if(user_ids.size()==0) {
					System.out.println("there is no buyers exists");
					break;
				}
				while(true) {
					while(true) {
						System.out.println("Select buyers id"
								+ "\npress 0 to cancel");
						num1=scan.next();
						try {
							buyer_id=Integer.parseInt(num1);
							break;
						}
					    catch(NumberFormatException e) {
					    	System.out.println("please enter numbers only");
					    }
					}
					if(buyer_id==0) {
						break;
					}
				if(user_ids.contains(buyer_id)) {
					CRUD.deleteUser(buyer_id,"buyers");
					System.out.println("this buyer is Deleated Sucessfully");
					break;
				}
				else {
					System.out.println("please enter given buyer ID only");
				}
				}
			}
			if(n==0) {
				break;
			}
		}
	}
	private void VOR_Sellers() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->deleate seller"
							+ "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
		    	VOR_Sellers();
		    }
			if(n==1) {
				String num1="";int seller_id=0;
				ArrayList<Integer> user_ids=aodb.readHouse();
				if(user_ids.size()==0) {
					System.out.println("there is no sellers exists");
					break;
				}
				while(true) {
					while(true) {
						System.out.println("Select seller id"
								+ "\npress 0 to cancel");
						num1=scan.next();
						try {
							seller_id=Integer.parseInt(num1);
							break;
						}
					    catch(NumberFormatException e) {
					    	System.out.println("please enter numbers only");
					    }
					}
					if(seller_id==0) {
						break;
					}
				if(user_ids.contains(seller_id)) {
					CRUD.deleteUser(seller_id,"sellers");
					System.out.println("this seller and his properties are Deleated Sucessfully");
					break;
				}
				else {
					System.out.println("please enter given seller ID only");
				}
				}
			}
			if(n==0) {
				break;
			}
		}
	}
}
