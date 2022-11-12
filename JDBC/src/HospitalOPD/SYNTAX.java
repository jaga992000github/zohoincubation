package HospitalOPD;
import java.sql.*;
import java.util.Formatter;
public class SYNTAX {
	public static void main(String[] args)throws Exception
	{
		String url="jdbc:mysql://localhost:3306/shopping";
		String user="root";
		String password="992000";
		String query="SELECT * FROM Persons ;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		Formatter fmt = new Formatter();  
		fmt.format("%3s %10s %10s\n", "Id", "Name", "points"); 
		System.out.print(fmt+"__________________________\n");  
		//UPDATE persons set personName = 'elite' where personId =8;
		//DELETE FROM persons where personId =8 and PersonName='elite';
		while(rs.next()) {
		//String value=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
			Formatter val = new Formatter();  
			int space=rs.getString(1).length();
			val.format("%3s %10s %7s", rs.getString(1), rs.getString(2), rs.getString(3));
		System.out.println(val);}
		st.close();
		con.close();
		
	}
}
