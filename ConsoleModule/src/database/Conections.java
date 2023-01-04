package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Conections {
	static Connection con;
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	
	static void connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://localhost:3306/module";
		String user="root";
		String password="992000";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		
	}
	
	
	static void close() throws SQLException  {
		st.close();
		con.close();
	}

}
