package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;

public class DBconection {
	static ResultSet rs;
	static Statement st;
	static Connection con;
	
	
	public static void mysql(Object TableValues) throws SQLException, Exception {
		
		String url="jdbc:mysql://127.0.0.1:3306/login";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, password);
		st=con.createStatement();
		
		//st.close();
		//con.close();
		
	}
}
