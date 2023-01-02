package database;

import java.sql.SQLException;

public class LoginDB extends Conections {
	
	public static boolean authenticate(String Table,String email,String Password) throws SQLException, ClassNotFoundException {
		connect();
		String passQuery="SELECT password FROM "+Table+" WHERE email='"+email+"' ;";
		rs=st.executeQuery(passQuery);
		if(rs.next()) {
		String pass=rs.getString(1);close();
		//System.out.println(pass);
		if(Password.equals(pass)) {
			return true;
		}}
		return false;
	}
	public static String GetName(String Table,String email) throws ClassNotFoundException, SQLException {
		connect();
		String Query="SELECT name from "+Table+" WHERE email='"+email+"';";
		rs=st.executeQuery(Query);
		rs.next();
		String name=rs.getString(1);
		//System.out.println(name);
		return name;
	}
	public static int GetId(String Table,String email) throws ClassNotFoundException, SQLException {
		connect();
		String query="select id from "+Table+" WHERE email='"+email+"';";
		rs=st.executeQuery(query);
		rs.next();
		int id=rs.getInt(1);
		return id;
	}
}
