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
		LoginDB ldb=new LoginDB();
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
			if(ldb.authenticate(table, email, pass)) {
				System.out.println("Welcome "+ldb.GetName(table, email));
			 BuyerOperations bo =new  BuyerOperations() ;
			 id=ldb.GetId(table, email);
			 bo.operate();
			}else {
				System.out.println("Wrong email or password");
				login();
			}
		}else if(user_type.equals("sellers")) {
			if(ldb.authenticate(table, email, pass)) {
				System.out.println("Welcome "+ldb.GetName(table, email));
			 SellerOperations so =new  SellerOperations() ;
			 id=ldb.GetId(table, email);
			 so.operate();
			}else {
				System.out.println("Wrong email or password");
				login();
			}
		}
	}
}
