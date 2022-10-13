package day6_pdf1_RailwayTickect;
import java.util.*;
class Cancel extends PersonDetails{
	Main m=new Main();
	Check check=new Check();
	
	Scanner scan=new Scanner(System.in);
	int PN;
	String ticketNo;
	
	
	void cancel(String[][] Tickets,String[]wait) {
		System.out.println("Enter the PNR Number");
		PN=scan.nextInt();
		System.out.print("for confirm press 1: \n"
						+"for Waiting press 2: \n"
						+"for RAC press 3: \n");
	
		int c=scan.nextInt();
		switch (c){
		case 1:Confirm_Cancel();break;
		case 2:Waiting_Cancel();break;
		default:System.out.print("Select from 1 to 4 only");
		}
		
		
	}
	
	void PD_ConfirmWait() {//to confirm a waiting list in PD after a confirm cancel
		int waiting_list=check.BalenceWaitSeatCount(wait);
		if(waiting_list < wait.length) {
		for(int i=0;i<20;i++) {
			for(int j=0;j<PD[0].length;j++) {
				if(PD[i][j][0]==null) {continue;}
				if(PD[i][j][3].charAt(0)=='w'
				&&PD[i][j][3].charAt(6)=='g') {
					PD[i][j][3]="confirm seat "+ticketNo;
					break;}
				}
			}
		}
	}
	
	void PD_WaitReduce() {
		int waiting_list=check.BalenceWaitSeatCount(wait);
		if(waiting_list < wait.length) {
		for(int i=0;i<20;i++) {
			for(int j=0;j<PD[0].length;j++) {
				if(PD[i][j][0]==null) {continue;}//to decrease the waiting list count in PD
				if(PD[i][j][3].charAt(0)=='w'
				&&PD[i][j][3].charAt(6)=='g') {
				String num= PD[i][j][3].charAt(13)+""+PD[i][j][3].charAt(14);
				int number=Integer.parseInt(num);
				number-=1;
				String N=String.valueOf(number);
				PD[i][j][3]="waiting seat "+N;
				}
		}}}
	}
	
	void  WaitReduce() {
		for(int i=wait.length-2;i>=0;i--) {
			if(wait[i].charAt(0)=='['&&wait[i].charAt(wait[i].length()-1)==']') {//to decrease  the waiting list
				String s=String.valueOf(i);
				wait[i+1]=s;}
				break;}
	}
	
	
	
	void Confirm_Cancel(){
		System.out.println("How many persons ?");
		int n=scan.nextInt();
		while(n>0) {
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
			}
			PD[PN-1][personNo-1][3]="cancelled";
		
			
			int waiting_list=check.BalenceWaitSeatCount(wait);
			if(waiting_list < wait.length) {
				PD_ConfirmWait();//to confirm a waiting list in PD after a confirm cancel
				PD_WaitReduce();
				
				for(int i=0;i<Tickets.length;i++) {
					for(int j=0;j<Tickets[0].length;j++) { 
						if((ticketNo).equals(Tickets[i][j])) {//to change in display
							Tickets[i][j]="["+ticketNo+"]";
							break;
							}
						}
				}WaitReduce() ;
			for(int i=0;i<4;i++)
			{	System.out.print(PD[PN-1][personNo-1][i]+" ");}
		}
			n-=1;}
	}
	//void RAC_Cancel(){
		
	//}
	
	void Waiting_Cancel(){
		System.out.println("How many persons ?");
		int n=scan.nextInt();
		while(n>0) {
			System.out.println("Enter Waitinglist No: ");
			String wno=scan.next();
			System.out.println("Enter the person Number");
			int pno=scan.nextInt();
			WaitReduce();
			PD_WaitReduce();
			PD[PN-1][pno-1][3]="cancelled";
			for(int j=0;j<4;j++)
			{	System.out.print(PD[PN-1][pno-1][j]+" ");}
		n--;}
	}
}	
