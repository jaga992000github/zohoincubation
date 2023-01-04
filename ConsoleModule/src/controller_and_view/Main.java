package controller_and_view;
import java.sql.SQLException;
import java.util.*;
public class Main {
	static Scanner scan= new Scanner(System.in);
	static String user_type;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		index();
	}
	private static void index() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("Please Select UserType");
			System.out.println("\n1->Seller"
						 	 + "\n2->Buyer"
						     + "\n3->Admin"
						     + "\n0->Exit");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				index();
		    }
			if(n==1) {
				user_type="sellers";
				selector();
			}
			else if(n==2) {
				user_type="buyers";
				selector();
			}
			else if(n==3) {
				user_type="admin";
				Login.login();
			}
			else if(n==0) {
				System.out.println("Thank you!!");
				break;
			}
			else {
				System.out.println("Enter a valid Number");
			}
		}
	}
	private static void selector() throws ClassNotFoundException, SQLException{
		String num="";int n=0;
		while(true) {
			System.out.println("\n1->Login"
							 + "\n2->Register"
						     + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				selector();
		    }
			if(n==1) {
				Login.login();
			}
			else if(n==2) {
				Register.register();
			}
			else if(n==0) {
				break;
			}
			else {
				System.out.println("Enter a valid Number");
			}
		}
	}

}
