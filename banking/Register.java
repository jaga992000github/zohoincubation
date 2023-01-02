package banking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
	static Scanner scan=new Scanner(System.in);
	static DB db=new DB();
	static ArrayList register=new ArrayList<>();
	
	static void register() throws SQLException, ClassNotFoundException {
		int accNo=0;
		try {
		accNo=db.getLastId("bank_register")+1001;register.add(accNo);}
		catch(SQLException e) {
		accNo=1001;register.add(accNo);
		}
		System.out.println("enter Name");
		String name=scan.next();register.add(name);
		int balence=10000;register.add(balence);
		
		ArrayList passval=new ArrayList<>();
		String pass=Password.enterPass();
		register.add(pass);
		db.insert(register,"bank_register");
		int id=db.getLastId("bank_register");
		passval.add(id);
		passval.add(pass);
		db.insert(passval,"pass_history");
		System.out.println("register Sucessfully \n "
				+ "your id is "+id
				+ "\nyour accNo is"+db.getLastAcc_no("bank_register"));
		
	}
}
