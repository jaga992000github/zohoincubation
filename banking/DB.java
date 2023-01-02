package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;

class DB {
	protected static Connection con;
	protected static Statement st;
	protected static ResultSet rs;
	
	protected static void connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://localhost:3306/bank";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
	}
	
	protected static void close() throws SQLException  {
		st.close();
		con.close();
	}
	
	private static String getColumnNameByIndex(String Table,int index) throws SQLException {
		String col_nameQuery="select column_name \r\n" + 
				"from information_schema.columns \r\n" + 
				"where table_name = '"+Table+"' and ordinal_position ="+index+";";
		rs=st.executeQuery(col_nameQuery);
		rs.next();
		return rs.getString(1);
	}
	
	static void insert(ArrayList values,String Table) throws SQLException, ClassNotFoundException  {
		connect();
		String insertquery;
		String col_1= null;//first column
		String lastID=null;//last prime key
		col_1=getColumnNameByIndex(Table,1);
			insertquery="insert into "+Table+"("+col_1+") value('0');";
			st.executeUpdate(insertquery);
			String lastidQuery="SELECT "+col_1+" from "+Table+" ORDER BY "+col_1+" desc ;";
			rs=st.executeQuery(lastidQuery);
			rs.next();
			lastID = rs.getString(1);
		for(int i=2;i<=values.size()+1;i++) {
			String col=getColumnNameByIndex(Table,i);//new colmn_name
			insertquery="update "+Table+" set "+col+"='"+values.get(i-2)+"' where "+col_1+"="+lastID+";";
			st.executeUpdate(insertquery);
			
		}close();	
	}
	
	int getLastId(String Table) throws SQLException, ClassNotFoundException {
		connect();
		String lastidQuery="SELECT cust_id from "+Table+" ORDER BY cust_id desc ;";
		rs=st.executeQuery(lastidQuery);
		rs.next();
		String lastID = rs.getString(1);close();
		int id=Integer.parseInt(lastID);
		return id;
	}
	int getLastAcc_no(String Table) throws SQLException, ClassNotFoundException {
		connect();
		String lastidQuery="SELECT acc_no from "+Table+" ORDER BY cust_id desc ;";
		rs=st.executeQuery(lastidQuery);
		rs.next();
		String accNo = rs.getString(1);close();
		int accno=Integer.parseInt(accNo);
		return accno;
	}
	static int getAcc_no(int id,String Table) throws SQLException, ClassNotFoundException {
		connect();
		String lastidQuery="SELECT acc_no from "+Table+" where cust_id="+id+" ;";
		rs=st.executeQuery(lastidQuery);
		rs.next();
		String accNo = rs.getString(1);close();
		int accno=Integer.parseInt(accNo);
		return accno;
	}

	boolean verify(int id,String pass) throws ClassNotFoundException, SQLException {
		connect();
		String Query="select pass from bank_register where cust_id="+id+";";
		rs=st.executeQuery(Query);
		rs.next();
		String query_pass=rs.getString(1);close();
		if(query_pass.equals(pass)) {
			return true;
		}
		return false;
	}
	
	int getBalence(int id) throws ClassNotFoundException, SQLException {
		connect();
		int amm=0;
		String Query="select balence from bank_register where cust_id="+id+";";
		rs=st.executeQuery(Query);
		rs.next();
		amm=Integer.parseInt(rs.getString(1));
		close();
		return amm;	
	}
	
	void setBalence(int id,int balence) throws ClassNotFoundException, SQLException {
		connect();
		String query="UPDATE bank_register SET balence ="+balence+" WHERE cust_id="+id+";";
		st.executeUpdate(query);
		close();
		}
	
	static void showBenificiary() throws SQLException, ClassNotFoundException {
		connect();
		String query="SELECT acc_no,name FROM bank_register;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();  
		fmt.format("%3s %10s\n" ,"  AccNO", "name"); 
		System.out.print(fmt+"__________________________\n");
		while(rs.next()) {
			  Formatter val = new Formatter();  
			  int space=rs.getString(1).length();
			  val.format("%3s %10s", rs.getString(1), rs.getString(2));
			  System.out.println(val);}close();
	}
	
	void transfer(int accNo,int amm) throws ClassNotFoundException, SQLException {
		connect();
		String Query="select balence from bank_register where acc_no="+accNo+";";
		rs=st.executeQuery(Query);
		rs.next();
		int balence=rs.getInt(1);
		balence+=amm;
		String query="UPDATE bank_register SET balence ="+balence+" WHERE acc_no="+accNo+";";
		st.executeUpdate(query);
		close();
		}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println(getAcc_no(3,"bank_register"));
	}
}
