package HospitalOPD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.util.*;
public class Main {
	static ResultSet rs;
	static Statement st;
	static Scanner scan =new Scanner(System.in);
	static String PatientName="",InTime="";
	static int m=0;
	static PatientsRecord pr=new PatientsRecord ();
	static PatientsHistory ph =new PatientsHistory();
	
	public static void main(String[] args)throws Exception
	{
		
		String url="jdbc:mysql://127.0.0.1:3306/hospitalOPD";
		String user="root";
		String password="992000";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		st=con.createStatement();
		
		
	
	while(true){
			System.out.println("1-Register\n2-PrintTables\n0-Quit");
			int n=scan.nextInt();
				if(n==0) {System.out.println("Thank You!!!!");break;}
	
				else if(n==1) {
					Register(m);
				}
		
			else if(n==2) {
				System.out.println("Patients Record\n");
				pr.Print();
				System.out.println("\n\n");
				System.out.println("Patients History\n");
				ph.Print();
			}	
			else {System.out.println("Please select 1,2,0 only");}
		}
		
		st.close();
		con.close();
	}
	
	
	
	static void Register(int m) throws SQLException, ParseException {
		System.out.println("Do You Have Patient ID\n press 1 for Yes\n press 0 for NO");
		m=scan.nextInt();
		int PatientID=0;
		while(true) {	
		if(m==1) {
			try{
				System.out.println("Enter Patient ID");
				PatientID=scan.nextInt();
				String nameSearchQuery="SELECT PatientName FROM PatientsRecord WHERE patientID ='"+PatientID +"' ;";
				rs=st.executeQuery(nameSearchQuery);
				rs.next();
				PatientName =rs.getString(1);}
			 catch(SQLException e) {
		        	System.out.println("Your Patient ID not found\n"
		        			+ "Give Details for register \n");
		        	m=0;m0();break;}
		System.out.println("Enter Patient InTime");
		InTime=scan.next();	
		System.out.println("Enter Docter Time");
		Long DoctorTime=scan.nextLong();
		ph.Insert(PatientID, InTime, DoctorTime);
		break;	
		}
		else if(m==0){
			m0();
		break;}
		else {
			System.out.println("press 1 or 0 only");}
		}
		
	}
	static void m0() throws SQLException, ParseException {
		System.out.println("Enter Patient Name");
		PatientName=scan.next();
		pr.insert(PatientName);
		String IDsearchQuery="select patientId from  PatientsRecord ORDER BY patientId DESC LIMIT 1;";
		rs=st.executeQuery(IDsearchQuery);
		rs.next();
		int PatientID =rs.getInt(1);
		System.out.println("Enter Patient InTime");
		InTime=scan.next();
		System.out.println("Enter Docter Time");
		Long DoctorTime=scan.nextLong();
		ph.Insert(PatientID, InTime, DoctorTime);
		
	}
	
}

