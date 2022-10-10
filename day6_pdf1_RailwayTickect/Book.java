package day6_pdf1_RailwayTickect;
import java.util.*;
class Book {
	Check check=new Check();
	Scanner scan =new Scanner(System.in);
	void confirmbook(String[][] Tickets,int persons) {
		int availseat=check.BalenceConfirmSeatCount(Tickets);
		PersonDetails pd=new PersonDetails();
		if(availseat>=persons) {
			for(int k=1;k<=persons;k++) {
			pd.scan(k);
			if(pd.age>5) {
			System.out.print("\nEnter the available person("+k+") seat No: ");
			String s=scan.next();
			s.trim();
			
			for(int i=0;i<Tickets.length;i++) {
				for(int j=0;j<Tickets[0].length;j++) {
					if(("["+s+"]").equals(Tickets[i][j]))
					{System.out.println("\nThis ticket is already booked");k-=1;break;}
					else if(s.equals(Tickets[i][j])) {
						Tickets[i][j]="["+Tickets[i][j]+"]";
						break;}
					}}
			System.out.println("person("+k+") seatno: "+s);}
			pd.print(k);}
			System.out.println("\nyour seats  has been booked in confirm!!\n\n");
			
			}
	}
		
	
	String[] waitingbook(String[]wait,int persons) { 
			{int waitbook=check.BalenceWaitSeatCount(wait);
			int bookedseats=wait.length-waitbook;
			if(waitbook>=persons){
				PersonDetails pd=new PersonDetails();
				for(int k=1;k<=persons;k++) {
					pd.scan(k);
				if(pd.age>5){for(int j=1;j<=persons;j++) {
						for(int i=wait.length-1;i>=0;i--) {if(wait[i].charAt(0)=='['
								&&wait[i].charAt(wait[i].length()-1)==']')
									{wait[i+1]="["+wait[i+1]+"]";break;}
				}}
				System.out.println("person("+k+") waiting list no "+(bookedseats+1));}
				pd.print(k);}
				System.out.println("\nyour "+persons+" seats has been booked in waiting list");}
			else{System.out.println("only "+waitbook+" waiting list are available\ntry after some time");}}
		return wait;
	}
}		


