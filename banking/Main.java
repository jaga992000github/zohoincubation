package banking;
import java.sql.SQLException;
import java.util.*;
class Main {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.println("1->register"
					+ "\n2->login"
					+ "\n3->Admin"
					+ "\n0->exit");
			int decide=scan.nextInt();
			if(decide==1) {
				Register.register();
			}
			else if(decide==2) {
				Login.login();
			}
			else if(decide==3) {
				admin();
			}
			else if(decide==0) {
				System.out.println("Thank you");
				break;
			}
			else {System.out.println("please select \ngiven numbers only");}
		}
	}
	private static void admin() throws ClassNotFoundException, SQLException {
		System.out.println("Enter password");
		String admin_pass=scan.next();
		if(admin_pass.equals("admin")) {while(true) {
			System.out.println("1->Show top 10 customers"
				       + "\n0->quit");
		int n=scan.nextInt();
		if(n==1) {
			DB2.Top10();
		}else {break;}}
		}else {System.out.println("wrong pass please enter correct");}
	}
}
