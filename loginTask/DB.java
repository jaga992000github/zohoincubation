package loginTask;
import java.util.*;
import java.sql.*;
public class DB {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	private static void connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
	}
	
	private static void close() throws SQLException  {
		st.close();
		con.close();
	}
	boolean verify(String email,String pass) throws ClassNotFoundException, SQLException {
		connect();
		String Query="select pass from register where email="+"'"+email+"'";
		rs=st.executeQuery(Query);
		rs.next();
		String query_pass=rs.getString(1);
		if(query_pass.equals(pass)) {
			return true;
		}
		return false;
	}
	private static String getColumnNameByIndex(String Table,int index) throws SQLException {
		String col_nameQuery="select column_name \r\n" + 
				"from information_schema.columns \r\n" + 
				"where table_name = '"+Table+"' and ordinal_position ="+index+";";
		rs=st.executeQuery(col_nameQuery);
		rs.next();
		return rs.getString(1);
	}
	
	void insert(ArrayList values,String Table) throws SQLException, ClassNotFoundException  {
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
	}static boolean  checkOld(String column,String value) throws ClassNotFoundException, SQLException {
		connect();
		String email=Login.getCurrent_email();
		String query="select "+column+" from register where email='"+email+"';";
		rs=st.executeQuery(query);
		rs.next();
		String old_val=rs.getString(1);
		if(old_val.equals(value)) {
			return true;
		}
		return false;
	}
	 boolean  checkPresence(String email) throws ClassNotFoundException, SQLException {
		connect();
		String query="select email from register where email='"+email+"';";
		rs=st.executeQuery(query);
		if(rs.next())
		 {
		String old_val=rs.getString(1);
		if(old_val.equals(email)) {
			return true;
		}}
		return false;
	}
     static void  update(String column,String value) throws SQLException, ClassNotFoundException {
		connect();
		String email=Login.getCurrent_email();
		String query="UPDATE register SET "+column+" ='"+value+"' WHERE email='"+email+"';";
		st.executeUpdate(query);
	}
}
