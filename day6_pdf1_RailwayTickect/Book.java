package day6_pdf1_RailwayTickect;
import java.util.*;
class Book {
	Check check=new Check();
	Scanner scan =new Scanner(System.in);
	void confirmbook(String[][] Tickets,int persons) {
		int availseat=check.BalenceConfirmSeatCount(Tickets);
		
		if(availseat>=persons) {
			for(int k=1;k<=persons;k++) {
			System.out.print("\nEnter the available seat("+k+") No: ");
			String s=scan.next();
			s.trim();
			
			for(int i=0;i<Tickets.length;i++) {
				for(int j=0;j<Tickets[0].length;j++) {
					if(("["+s+"]").equals(Tickets[i][j]))
					{System.out.print("This ticket is already booked");k-=1;break;}
					if(s.equals(Tickets[i][j])) {
						Tickets[i][j]="["+Tickets[i][j]+"]";
						break;}
					}}
			}
			System.out.println("\nyour seats  has been booked in confirm!!\n\n");
			Main main=new Main();
			}
	}
		
	
	String[] waitingbook(String[]wait,int persons) { 
			{int waitbook=check.BalenceWaitSeatCount(wait);
			if(waitbook>=persons){
				for(int j=1;j<=persons;j++) {
				for(int i=wait.length-1;i>=0;i--) {if(wait[i].charAt(0)=='['
						&&wait[i].charAt(wait[i].length()-1)==']')
				{wait[i+1]="["+wait[i+1]+"]";break;}
				}}
				System.out.println("\n!your "+persons+" seats has been booked in waiting list!");}
			else{System.out.println("Waiting list also full\ntry after some time");}}
		return wait;
	}
}		


