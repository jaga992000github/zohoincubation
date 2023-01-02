package loginTask;
import java.sql.SQLException;
import java.util.*;
public class Login {
	static Scanner scan=new Scanner(System.in);
	static DB db=new DB();
	private static String current_email;
	protected int login() throws ClassNotFoundException, SQLException {
		System.out.println("EnterEmail");
		String email =scan.next();
		System.out.println("EnterPass");
		String pass =scan.next();
		boolean verification =db.verify(email, pass);
		if(verification) {
			System.out.println("!!logged Sucessfully");
			current_email=email;
			System.out.println("1->update\n"
					+ "0->Quit");
			int decide=scan.nextInt();
			if(decide==0) {
			return 0;}
			else {
				update();
			}
		}else {System.out.println("Wrong email or password");login();}
		return 0;
	}
	private static void change(String column,String value) throws ClassNotFoundException, SQLException {
		if(db.checkOld(column, value)) {
			while(db.checkOld(column, value)){
			System.out.println("This value is same as old one \n"
					+ "please enter new value");
			value=scan.next();}
		}
		else{db.update(column,value);}
	}
	
	private static void update() throws ClassNotFoundException, SQLException {
		System.out.println("1->email\n"
				+ "2->phno\n"
				+ "3->pass");
		int n= scan.nextInt();
		System.out.println("Enter new value");
		String value=scan.next();
		switch(n) {
		case 1:{
				change("email",value);break;}
		case 2:{
				change("phno",value);break;}
		case 3:{
				change("pass",value);break;}
		}
	}
	
	
	
	
	
	public static String getCurrent_email() {
		return current_email;
	}
	public static void setCurrent_email(String current_email) {
		Login.current_email = current_email;
	}
}
