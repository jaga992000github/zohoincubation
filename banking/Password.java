package banking;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Password {
	static Scanner scan=new Scanner(System.in);
	
	public static String enterPass() {
		while(true) {
			String pass1=null;
			while(true) {
				System.out.println("enter pass"
						+ "\n(pass must be contain atleast"
						+ "\n2_nums 2_small 2_caps)");
				pass1=scan.next();
				if(checkStrength(pass1)) {
					break;
				}else {System.out.println("please enter a Strong pass");}
			}
			System.out.println("enter pass again");
			String pass2=scan.next();
			if(pass1.equals(pass2)) {
				return encrypt(pass1);
			}else {System.out.println("pass not matched \ntype again");}
		}
	}
	static void changePass() throws ClassNotFoundException, SQLException {
		ArrayList pass_his=new ArrayList<>();
		int id=Login.logged_userID;
		String pass=enterPass();
		if(DB2.check_old3_pass(id,pass)) {
			DB2.updatePass(id, pass);
			pass_his.add(id);
			pass_his.add(pass);
			DB.insert(pass_his,"pass_History");
			System.out.println("Your password is changed");
		}else {
			System.out.println("it is similar to your old pass"
								+ "\n please enter new one");
			changePass();}
	}
	static void forceChange() throws ClassNotFoundException, SQLException {
		int id=Login.logged_userID;
		int count=DB2.countTrans(id);
		if (count%5==0) {
			changePass();
		}
	}

	static boolean checkStrength(String pass) {
		String pattern1="[a-z]";
		String pattern2="[A-Z]";
		String pattern3="[0-9]";
		int total=0;
		for(int i=1;i<=3;i++) {
			String pattern = null;
			switch(i) {
			case 1:{pattern=pattern1;break;}
			case 2:{pattern=pattern2;break;}
			case 3:{pattern=pattern3;break;}
			}
			Pattern p =Pattern.compile(pattern);
			Matcher m=p.matcher(pass);
			int count=0;
			while(m.find()) {
				count+=1;
				if(count==2) {
					total+=count;
					System.out.println("total"+total+" count"+count);
					break;
				}	
			}
		}if(total==6) {return true;}
		return false;
	}
	public static void main(String[] args) {
		System.out.println("enter pass");
		String pass=scan.next();
		System.out.println(checkStrength(pass));
	}
	static String encrypt(String pass) {
		String enc_pass="";
		for(int i=0;i<pass.length();i++) {
			char ch1;
			char ch=pass.charAt(i);
			if(ch=='z') {
				ch1='a';
			}
			else if(ch=='Z') {
				ch1='A';
			}else {
			ch1=(char) (ch+1);
			}enc_pass+=ch1;
		}
		return enc_pass;		
	}
}
