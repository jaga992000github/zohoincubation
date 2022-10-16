package day6_pdf1_RailwayTicket;
import java.util.*;
public class RAC extends Cancel {
	public void racbook(String ticketNo) {
	
		int n=2;
		while(n>0) {
		for(int i=0;i<20;i++) {
			for(int j=0;j<PD[0].length;j++) {
				if(PD[i][j][0]!=null&&
				PD[i][j][3].charAt(0)=='w'
				&&PD[i][j][3].charAt(6)=='g') {
					PD[i][j][3]="RAC confirm seat no: "+ticketNo;
					break;
				}

			}
		}
		WaitReduce();
		PD_WaitReduce();
		n-=1;}for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) { 
				if((ticketNo).equals(Tickets[i][j])) {//to change in display
					Tickets[i][j]="("+ticketNo+")";
					break;
					}
				}
		}
}
}
