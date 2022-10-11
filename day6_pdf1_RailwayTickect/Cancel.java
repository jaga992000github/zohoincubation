package day6_pdf1_RailwayTickect;
import java.util.*;
class Cancel extends PersonDetails{
	Main m=new Main();
	Check check=new Check();
	
	Scanner scan=new Scanner(System.in);
	int PN;
	void cancel(String[][] Tickets,String[]wait) {
		System.out.println("Enter the PNR Number");
		PN=scan.nextInt();
		System.out.print("for confirm press 1: \n"
						+"for RAC press 2: \n"
						+"for Baby press 3: \n"
						+"for Waiting press 4: \n");
		while(true) {
		int c=scan.nextInt();
		switch (c){
		case 1:Confirm_Cancel(Tickets,wait);break;
		default:System.out.print("Select from 1 to 4 only");break;
		}
		}
		
	}
	void Confirm_Cancel(String[][] Tickets,String[]wait){
		
		System.out.println("Enter the Ticket Number");
		String ticketNo=scan.next();
		System.out.println("Enter the person Number");
		int personNo=scan.nextInt();
		
		for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) { 
				if(("["+ticketNo+"]").equals(Tickets[i][j])) {
					Tickets[i][j]=ticketNo;
					break;
					}
				}
			}//for(int i=0;i<4;i++)
			//{	PD[PN-1][personNo-1][i]="cancelled";}
		
			int waiting_list=check.BalenceWaitSeatCount(wait);
			if(waiting_list < wait.length) {
			for(int i1=0;i1<wait.length;i1++) {
				if(wait[i1].charAt(0)!='['&&wait[i1].charAt(wait[i1].length()-1)!=']') {
					String s=String.valueOf(i1);
					i1-=1;
					wait[i1]=s;}
					break;}
			
			}for(int i=0;i<4;i++)
			{	System.out.print(PD[PN-1][personNo-1][i]+" ");}
		}
	
	/*void RAC_Cancel(){
		
	}
	void Baby_Cancel(){
		
	}
	void Waiting_Cancel(){
		
	}*/
}
