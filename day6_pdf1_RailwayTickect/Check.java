package day6_pdf1_RailwayTickect;
import java.util.*;
public class Check {
	int BalenceConfirmSeatCount(String[][] Tickets) {
		int totalseats=63;
		int bookedseats=0;
		int balenceseats=0;
		for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) {
				if(Tickets[i][j].charAt(0)=='['
						&&Tickets[i][j].charAt(Tickets[i][j].length()-1)==']'
						&&Tickets[i][j].charAt(1)!='_' )
				{bookedseats+=1;}
				}
			}return balenceseats=totalseats-bookedseats;		
	}
	
	
	int BalenceWaitSeatCount(String[] wait) {
		int totalseats=wait.length;
		int bookedseats=0;
		int balenceseats=0;
		for(int i=0;i<totalseats;i++) {if(wait[i].charAt(0)=='['
				&&wait[i].charAt(wait[i].length()-1)==']') {bookedseats+=1;}
			}
		balenceseats=totalseats-bookedseats;
		return balenceseats;		
	}
	
	int BalenceRACSeatCount(String[][] Tickets) {
		int totalseats=18;
		int bookedseats=0;
		int balenceseats=0;
		for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) {
				if(Tickets[i][j].charAt(0)=='['&&Tickets[i][j].charAt(Tickets[i][j].length()-1)==']') 
				{bookedseats+=1;}
				}
			}return balenceseats=totalseats-bookedseats;		
	}
}
