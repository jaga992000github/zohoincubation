package loginTask;
import java.sql.SQLException;
import java.util.*;
public class Main {
	static Scanner scan=new Scanner(System.in);
	static DB db=new DB();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while (true) {
		System.out.println("1->register\n"
				+ "2->login\n"
				+ "0->Quit");
		int decission=scan.nextInt();
		if(decission==0) {
			break;
		}
		else if (decission==2) {
			Login login =new Login();
		login.login();}
		else {
			register();
		}
		}
	}

	private static void register() throws ClassNotFoundException, SQLException {
		ArrayList values=new ArrayList();
		System.out.println("Enter Email");
		String email =scan.next();
		boolean presense =db.checkPresence(email);
		if(presense) {
			System.out.println("this email already exists ");
			register();
		}
		values.add(email);
		System.out.println("Enter Name");
		String name =scan.next();
		values.add(name);
		System.out.println("Enter phno");
		String phno =scan.next();
		values.add(phno);
		System.out.println("Enter pass");
		String pass =scan.next();
		values.add(pass);
		db.insert(values,"register");
	}
}
