package core_module;
import java.sql.SQLException;
import java.util.*;
import database.LoginDB;
public class Login {
	static String user_type=Main.user_type;
	static String table=user_type;
	static int id;
	public static void login() throws ClassNotFoundException, SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter email");
		String email=scan.next();
		System.out.println("Enter password");
		String pass=scan.next();	
		if(user_type.equals("admin")) {
			if(email.endsWith("@Admin")&&pass.equals("admin")) {
				System.out.println("Welcome admin");
			}else {
				System.out.println("Wrong email or password");
				login();
			}
		}else if(user_type.equals("buyers")) {
			if(LoginDB.authenticate(table, email, pass)) {
				System.out.println("Welcome "+LoginDB.GetName(table, email));
			 BuyerOperations bo =new  BuyerOperations() ;
			 id=LoginDB.GetId(table, email);
			 bo.operate();
			}else {
				System.out.println("Wrong email or password");
				login();
			}
		}else if(user_type.equals("sellers")) {
			if(LoginDB.authenticate(table, email, pass)) {
				System.out.println("Welcome "+LoginDB.GetName(table, email));
			 SellerOperations so =new  SellerOperations() ;
			 id=LoginDB.GetId(table, email);
			 so.operate();
			}else {
				System.out.println("Wrong email or password");
				login();
			}
		}
	}
}
