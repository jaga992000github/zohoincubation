package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class RegisterDB extends Conections {
	
	public static boolean checkRegister(String email,String Table) throws ClassNotFoundException, SQLException {
		connect();
		String Query ="SELECT email FROM "+Table+" WHERE email ='"+email+"';";
		rs=st.executeQuery(Query);
		if(rs.next()) {
			return true;
		}
		return false;
	}
}



