package banking;
import java.sql.SQLException;
import java.util.*;
public class Operations {
	static Scanner scan=new Scanner(System.in);
	static DB db=new DB();
	static DB2 db2=new DB2();
	static ArrayList trans =new ArrayList<>();
	static Login log=new Login();
	static int id=log.logged_userID;
	static Password pas=new Password();
	static void operate() throws ClassNotFoundException, SQLException {
	while(true) {
		id=log.logged_userID;
		System.out.println("1->Withdawal"
					   + "\n2->Cash Deposit"
					   + "\n3->Check Balence"
					   + "\n4->Account Transfer"
					   + "\n5->Transaction Details"
					   + "\n6->Change passWord"
					   + "\n0->Logout");
		int decide=scan.nextInt();
		if(decide==1) {withDraw();}
		else if(decide==2) {deposit();}
		else if(decide==3) {checkBal();}
		else if(decide==4) {transfer();}
		else if(decide==5) {displayTransactions();}
		else if(decide==6) {Password.changePass();}
		else if(decide==0) {break;}
		else {System.out.println("select a valid no only");}
		}
	}
	
	private static void withDraw() throws ClassNotFoundException, SQLException {
		System.out.println("Enter ammount");
		int amm=scan.nextInt();
		if(debit(amm)) {
			trans.add(id);trans.add(db.getAcc_no(id,"bank_register"));
			trans.add("WithDraw");trans.add(amm);trans.add("debit");
			trans.add("self");trans.add(db.getBalence(id));db.insert(trans,"banking_history");trans.clear();
		}pas.forceChange();
		if(amm>5000) {debit(10);}
		int count=db2.countTrans(id);
		if(count%10==0) {
			debit(100);
		}
	}
	
	private static void deposit() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Ammout \nto be Deposit");
		int amm=scan.nextInt();
		credit(amm);
		trans.add(id);trans.add(db.getAcc_no(id,"bank_register"))
		;trans.add("deposit");trans.add(amm);trans.add("credit");
		trans.add("self");trans.add(db.getBalence(id));
		db.insert(trans,"banking_history");trans.clear();
	}
	private static void checkBal() throws ClassNotFoundException, SQLException {
		System.out.println(db.getBalence(id));
	}
	private static boolean debit(int amm) throws ClassNotFoundException, SQLException {
		int balence=db.getBalence(id);
		balence-=1000;
		if(amm<=balence) {
			balence+=1000;
			balence-=amm;
			db.setBalence(id, balence);
			return true;
		}else {
			System.out.println("insufficient balence "
					+ "\n (or) minimum balence");
		}
		return false;
	}
	
	private static void credit(int amm) throws ClassNotFoundException, SQLException {
	int balence=db.getBalence(id);
	balence+=amm;
	db.setBalence(id, balence);}
	
	private static void transfer() throws ClassNotFoundException, SQLException  {
		db.showBenificiary();
		System.out.println("enter accNo");
		int accNo=scan.nextInt();
		System.out.println("enter ammount");
		int amm=scan.nextInt();
		try {
		db.transfer(accNo, amm);
		debit(amm);
		trans.add(id);trans.add(db.getAcc_no(id,"bank_register"));
		trans.add("transfer");trans.add(amm);trans.add("debit");
		trans.add(accNo);trans.add(db.getBalence(id));
		db.insert(trans,"banking_history"); trans.clear();
		
		int trans_id= DB2.getIdByTransAccNo(accNo);
		trans.add(trans_id);trans.add(accNo);
		trans.add("transfer");trans.add(amm);trans.add("credit");
		trans.add(db.getAcc_no(id,"bank_register"));trans.add(db.getBalence(trans_id));
		db.insert(trans,"banking_history"); trans.clear();
		System.out.println("Transfer sucessfully!!");
		}
		catch(SQLException e) {
			System.out.println("acc not found \nenter valid accno");
			transfer();
		}pas.forceChange();
		if(amm>5000) {bank_debit(10);}
		int count=db2.countTrans(id);
		if(count%10==0) {
			bank_debit(100);
		}
	}
	private static void displayTransactions() throws ClassNotFoundException, SQLException {
		db2.showTransactions(id);
	}
	private static void bank_debit(int amm) throws ClassNotFoundException, SQLException {
		int balence=db.getBalence(id);
		balence-=amm;
		db.setBalence(id, balence);
		trans.add(id);
		trans.add(db.getAcc_no(id,"bank_register"));
		trans.add("mainanence");
		trans.add("debit");
		trans.add(amm);
		trans.add("bank");
		trans.add(db.getBalence(id));
		db.insert(trans,"banking_history");trans.clear();
	}
}
