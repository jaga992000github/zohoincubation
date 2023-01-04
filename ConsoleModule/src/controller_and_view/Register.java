package controller_and_view;
import java.sql.SQLException;
import java.util.*;

import model.CRUD;
import model.RegisterDB;
public class Register {
	static Scanner scan=new Scanner(System.in);
	static String user_type=Main.user_type;
	static String table=user_type;
	static RegisterDB rdb=new RegisterDB();
	
	public static void register() throws ClassNotFoundException, SQLException{
		if(user_type.equals("buyers")) {
			buyers_reg();
		}else {
			sellers_reg();
		}	
	}
	private static void buyers_reg() throws ClassNotFoundException, SQLException {
		ArrayList values=new ArrayList();
		System.out.println("Email");
		String email=scan.next();values.add(email);
		boolean flag =rdb.checkRegister(email,table);
		if(flag) {
			System.out.println("This email already exists"
						   + "\nplease give another mail");
			values.clear();
			buyers_reg();
		}else {
		System.out.println("Password");
		String pass=scan.next();values.add(pass);
		System.out.println("Name");
		String name=scan.next();values.add(name);
		System.out.println("Age");
		String age=scan.next();values.add(age);
		System.out.println("Gender");
		String gender=scan.next();values.add(gender);
		System.out.println("PhoneNO");
		String phno=scan.next();values.add(phno);
		System.out.println("Designation");
		String design =scan.next();values.add(design);
		CRUD.insert(values,table);
		System.out.println("register Sucessfully");
		}
	}
	private static void sellers_reg() throws ClassNotFoundException, SQLException {
		ArrayList values=new ArrayList();
		System.out.println("Email");
		String email=scan.next();values.add(email);
		boolean flag =rdb.checkRegister(email,table);
		if(flag) {
			System.out.println("This email already exists"
						   + "\nplease give another mail");
			values.clear();
			buyers_reg();
		}else {
		System.out.println("Password");
		String pass=scan.next();values.add(pass);
		System.out.println("Name");
		String name=scan.next();values.add(name);
		System.out.println("Gender");
		String gender=scan.next();values.add(gender);
		System.out.println("PhoneNO");
		String phno=scan.next();values.add(phno);
		CRUD.insert(values,table);
		System.out.println("register Sucessfully");
		}
	}
	
}
