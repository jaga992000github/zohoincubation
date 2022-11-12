package HospitalOPD;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.concurrent.ThreadLocalRandom;

public class PatientsHistory extends PatientsRecord {
	public static void Insert(int PatientID,String InTime,Long DoctorTime) throws SQLException, ParseException {
		LocalTime format = null;
		LocalTime inTime=format.parse(InTime);
		LocalTime it=inTime.plusMinutes(DoctorTime);
		it=it.plusMinutes(15);
		String starttime=it.toString();
		String endtime=it.plusMinutes(20).toString();
		String OutTime=LocalTimebetween(InTime,endtime);
		LocalTime outtime = format.parse(OutTime);
		String sorry="sorry for delay";
		String ThankYou="ThankYou";
		int waitingTime=WaitingTime( PatientID,inTime,DoctorTime, outtime);
		if( waitingTime==0||DoctorTime<10L) {
		String outputInsertQuery="INSERT INTO PatientsHistory VALUES('"+PatientID+"','"+InTime+"','"+DoctorTime+"','"+outtime+"','"+waitingTime+"','"+ThankYou+"');";
		st.executeLargeUpdate(outputInsertQuery);}
		else {String outputInsertQuery="INSERT INTO PatientsHistory VALUES('"+PatientID+"','"+InTime+"','"+DoctorTime+"','"+outtime+"','"+waitingTime+"','"+sorry+"');";
		st.executeLargeUpdate(outputInsertQuery);}
	}

	public static void DeleteRow(int PatientID) throws SQLException {
		String InputDeleteQuery="DELETE FROM PatientsHistory WHERE PatientID ='"+ PatientID+"';";
		st.executeUpdate(InputDeleteQuery);
	}

	public static int WaitingTime(int PatientID,LocalTime inTime,Long DoctorTime,LocalTime outtime) throws SQLException {
		LocalTime format = null;
		inTime=inTime.plusMinutes(DoctorTime);
		inTime=inTime.plusMinutes(15);
		int WaitingTime=(int)outtime.until(inTime,ChronoUnit.MINUTES);
		if(WaitingTime<0) {WaitingTime*=-1;}
		return WaitingTime;
	}

	public static void Print() throws SQLException {
		String outputDisplayQuery="SELECT * FROM PatientsHistory ;";
		rs=st.executeQuery(outputDisplayQuery);
	
		Formatter title = new Formatter();  
		title.format("%3s %10s %14s %10s %15s %10s\n", "PatientID", "InTime", "DocterTime", "Outime","WaitingTime","Appolagize"); 
		System.out.print(title+"----------------------------------------------------------------------------\n");  
	
		while(rs.next()) {
			Formatter val = new Formatter();  
			//int space=rs.getString(1).length();
			val.format("%4s %14s  %5s mins %14s %8s mins %17s", rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(val);}
	
	}
	
	static String LocalTimebetween(String st,String et) {
		LocalTime lt=null;
		LocalTime startTime=lt.parse(st);
		LocalTime endTime=lt.parse(et);
		
		int startSeconds = startTime.toSecondOfDay();
	    int endSeconds = endTime.toSecondOfDay();
	    int randomTime = ThreadLocalRandom
	      .current()
	      .nextInt(startSeconds, endSeconds);
	    LocalTime answer=LocalTime.ofSecondOfDay(randomTime);
	    String ans=answer.toString();
	    String OutTime="";
		for(int i=0;i<5;i++) {
			OutTime+=ans.charAt(i);
		}
	    return OutTime ;
	}
}