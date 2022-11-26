package db;
import java.util.*;
import java.sql.*;
public class DBC {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public static void connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://localhost:3306/module";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
	}
	
	public static void close() throws SQLException  {
		st.close();
		con.close();
	}

	
	public static String getColumnNameByIndex(String Table,int index) throws SQLException {
		String col_nameQuery="select column_name \r\n" + 
				"from information_schema.columns \r\n" + 
				"where table_name = '"+Table+"' and ordinal_position ="+index+";";
		rs=st.executeQuery(col_nameQuery);
		rs.next();
		return rs.getString(1);
	}
	
	
	public static void insert(ArrayList values,String Table) throws SQLException, ClassNotFoundException  {
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
			
		}
	}
	public static boolean authenticate(String Table,String email,String Password) throws SQLException, ClassNotFoundException {
		connect();
		System.out.println("auth called");
		String passQuery="SELECT password FROM "+Table+" WHERE email='"+email+"' ;";
		rs=st.executeQuery(passQuery);
		if(rs.next()) {
		String pass=rs.getString(1);
		System.out.println(pass);
		if(Password.equals(pass)) {
			return true;
		}}
		return false;
	}
	
	public static boolean checkRegister(String email,String Table) throws ClassNotFoundException, SQLException {
		connect();
		String Query ="SELECT email FROM "+Table+" WHERE email ='"+email+"';";
		rs=st.executeQuery(Query);
		if(rs.next()) {
			return true;
		}
		return false;
	}
	public static String GetName(String Table,String email) throws ClassNotFoundException, SQLException {
		connect();
		String Query="SELECT name from "+Table+" WHERE email='"+email+"';";
		rs=st.executeQuery(Query);
		rs.next();
		String name=rs.getString(1);
		System.out.println(name);
		return name;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		connect();
		System.out.println(getColumnNameByIndex("buyers",1));
	}
}

