package day6_pdf1_RailwayTicket;
import java.util.*;
class Book extends PersonDetails {
	Check check=new Check();
	Scanner scan =new Scanner(System.in);
	public String s;
	void confirmbook(String[][] Tickets,int persons) {
		int availseat=check.BalenceConfirmSeatCount(Tickets);
		if(availseat>=persons) {
			for(int k=1;k<=persons;k++) {
			scan(k);
			if(age>5) {
			System.out.print("\nEnter the person("+k+") seat No: ");
			s=scan.next();
			s.trim();
			//int pnrno=pd.pnrno;
			//PDdata[pnrno][k-1].seatNo=s;
			PD[pnrno][k-1][3]="confirm seat "+s;
			for(int i=0;i<Tickets.length;i++) {
				for(int j=0;j<Tickets[0].length;j++) {
					if(("["+s+"]").equals(Tickets[i][j]))
					{System.out.println("\nThis ticket is already booked");k-=1;break;}
					else if(s.equals(Tickets[i][j])) {
						Tickets[i][j]="["+Tickets[i][j]+"]";
						break;}
					}}
			
			//System.out.println("person("+k+") seatno: "+PDdata[pnrno][k-1].seatNo);}
			System.out.println("person("+k+") Ticket: "+PD[pnrno][k-1][3]);}
			else {
				PD[pnrno][k-1][3]="Baby Ticket";
				System.out.println("person("+k+") Ticket: "+PD[pnrno][k-1][3]);}
			print(k);}
			System.out.println("\nyour seats  has been booked in confirm!!\n\n");
			
			}
	}
		
	
	String[] waitingbook(String[] wait,int waitPersons,int totalpersons) { 
		System.out.println("Waiting list");	
		int waitbook=check.BalenceWaitSeatCount(wait);
		int bookedseats=wait.length-waitbook;	
		if(waitbook>=waitPersons){
				PersonDetails pd=new PersonDetails();
				int start=(totalpersons-waitPersons)+1;
				
				for(int k=start;k<=totalpersons;k++) {
					waitbook=check.BalenceWaitSeatCount(wait);
					bookedseats=wait.length-waitbook;
					pd.scan(k);
				if(pd.age>5){
						for(int i=0;i<wait.length;i++) {if(wait[i].charAt(0)!='['
								&&wait[i].charAt(wait[i].length()-1)!=']')
									{wait[i]="["+wait[i]+"]";break;}
				}
				String NO=String.valueOf(bookedseats+1);
				PD[pnrno][k-1][3]="waiting seat "+NO;
				System.out.println("person("+k+") waiting seat no "+(bookedseats+1));}
				else {
					PD[pnrno][k-1][3]="Baby Ticket";
					System.out.println("person("+k+") Ticket: "+PD[pnrno][k-1][3]);}
				pd.print(k);}
				System.out.println("\nyour "+waitPersons+" seats has been booked in Waiting list");
				}
				
				
			else{System.out.println("only "+waitbook+" waiting list are available\ntry after some time");}
		return wait;
	}
}		