package banking;
import java.sql.SQLException;
import java.util.*;
public class Login  {
	static Scanner scan=new Scanner(System.in);
	static DB db=new DB();
	static int logged_userID;
	static void login() throws ClassNotFoundException, SQLException  {
		System.out.println("enter id");
		int id =scan.nextInt();
		System.out.println("enter pass");
		String pass =scan.next();
		String unen_pass=Password.encrypt(pass);
		if(db.verify(id, unen_pass)) {
			System.out.println("Welcome!!");
			logged_userID=id;
			Operations.operate();
		}else {System.out.println("wrong pass or id");}
	}
	
	
	private static String decrypt(String pass) {
		String unenc_pass="";
		for(int i=0;i<pass.length();i++) {
			char ch1;
			char ch=pass.charAt(i);
			if(ch=='a') {
				ch1='z';
			}
			else if(ch=='A') {
				ch1='Z';
			}else {
			ch1=(char) (ch-1);
			}unenc_pass+=ch1;
		}
		return unenc_pass;		
	}
}
