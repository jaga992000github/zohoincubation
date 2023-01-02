package banking;

import java.sql.SQLException;
import java.util.Formatter;

public class DB2 extends DB{
	static void showTransactions(int cust_id) throws SQLException, ClassNotFoundException {
		connect();
		String query="SELECT id,acc_no,operation,ammount_moved,moved_type,trans_acc,balence "
				+ "FROM banking_history where cust_id="+cust_id+";";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();  
		fmt.format("%3s %7s %12s %10s %10s %10s %10s\n" ,"|Trans_id|","|acc_no|","|operation|","|ammount_moved|","|moved_type|","|trans_acc|","|balence|"); 
		System.out.print(fmt+"______________________________________________________________________\n");
		while(rs.next()) {
			Formatter val = new Formatter();  
			int space=rs.getString(1).length();
			val.format("%3s %12s %13s %10s %10s %15s %10s", rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
			System.out.println(val);
		}
		close();
	}
	public static int getIdByTransAccNo(int accNo) throws ClassNotFoundException, SQLException {
		connect();
		String query="select cust_id from bank_register where acc_no="+accNo+";";
		rs=st.executeQuery(query);
		rs.next();
		int id=Integer.parseInt(rs.getString(1));
		return id;
	}
	public static void Top10() throws ClassNotFoundException, SQLException {
		connect();
		String query="select acc_no,name,balence "
				+ "from bank_register ORDER BY balence;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();  
		fmt.format("%3s %10s %12s\n" ,"acc_no","name","balence"); 
		System.out.println(fmt+"---------------------------------");
		while(rs.next()) {
			Formatter val = new Formatter();  
			int space=rs.getString(1).length();
			val.format("%3s %12s %10s", rs.getString(1), rs.getString(2),
					rs.getString(3));
			System.out.println(val);}close();
	}
	
	public static boolean check_old3_pass(int id,String newpass) throws ClassNotFoundException, SQLException {
		connect();
		int i=0;
		String query="select pass from pass_history where cust_id="+id+" ORDER BY id desc ;";
		rs=st.executeQuery(query);
		while(rs.next()&&i<3) {
			String oldpass=rs.getString(1);
			if(oldpass.equals(newpass)) {
				return false;
			}
		}close();
		return true;
	}
	
	public static void updatePass(int id ,String pass) throws ClassNotFoundException, SQLException {
		connect();
		String query="update bank_register set pass='"+pass+"' where cust_id = "+id+";";
		st.executeUpdate(query);close();
	}
	public static int countTrans(int id) throws ClassNotFoundException, SQLException {
		connect();
		String query="select id from banking_history where cust_id="+id+" and operation ='transfer';";
		rs=st.executeQuery(query);
		int i=0;
		while(rs.next()) {
			i+=1;
		}
		close();
		return i;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	}
	
}
