package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;


public class Queries {
	
	
	public static Connection mysql() throws SQLException, Exception {
		
		String url="jdbc:mysql://127.0.0.1:3306/login";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		
		return con;
		//st.close();
		//con.close();
		
	}
	public static boolean insert(String email,String pass) throws Exception {
		System.out.println("---------------"+email+" "+pass);
		Connection con = Queries.mysql();
		try {
			Statement st = con.createStatement();
			String InsertQuery ="INSERT INTO register (email,password) VALUES('"+email+"','"+pass+"');";
			st.executeUpdate(InsertQuery);
			System.out.println("----------------------");
			st.close();
			return true;
		
		}
		catch(SQLException e) {
			
			con.close();
		}
		
		return false;
	}
//
//	public static void DeleteRow(String email) throws SQLException {
//		String DeleteQuery="DELETE FROM register WHERE PatientID ='"+email+"';";
//		st.executeUpdate(DeleteQuery);
//		st.close();
//		con.close();
//	}
//	
	
}
