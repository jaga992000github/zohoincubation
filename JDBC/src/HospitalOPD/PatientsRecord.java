package HospitalOPD;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;
public class PatientsRecord extends Main{
	public static void insert(String PatientName) throws SQLException, ParseException {
		String InputInsertQuery="INSERT INTO PatientsRecord VALUES(0,'"+PatientName+"');";
		st.executeLargeUpdate(InputInsertQuery);
	}

	public static void DeleteRow(int PatientID) throws SQLException {
		String InputDeleteQuery="DELETE FROM PatientsRecord WHERE PatientID ='"+ PatientID+"';";
		st.executeUpdate(InputDeleteQuery);
	}
	
	
	 public static void Print() throws SQLException {
		String InputDisplayQuery="SELECT * FROM PatientsRecord ;";
		rs=st.executeQuery(InputDisplayQuery);
		
		Formatter title = new Formatter();  
		title.format("%3s %15s\n", "PatientID", "PatientName"); 
		System.out.print(title+"------------------------------\n");  
		
		while(rs.next()) {
			Formatter val = new Formatter();  
			//int space=rs.getString(1).length();
			val.format("%4s %16s", rs.getInt(1), rs.getString(2));
		System.out.println(val);}
	}
}