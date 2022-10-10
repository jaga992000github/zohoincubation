package day6_pdf1_RailwayTickect;
import java.util.*;
class Main {
	
	static void ShowSeats(String[][] Tickets) {
		for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) {
				System.out.print(Tickets[i][j]+" ");
			}System.out.println();
			if(i%2==0) {System.out.println();}
		}
	}
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		String[][] Tickets=
			/*{
			{"01","[______]","[__]","[__]","[__]"},
			{"02","[______]","03","04","05"},
			{"09","[______]","08","07","06"},
			{"10","[______]","11","12","13"},
			{"17","[______]","16","15","14"},
			{"18","[______]","19","20","21"},
			{"25","[______]","24","23","22"},
			{"26","[______]","27","28","29"},
			{"33","[______]","32","31","30"},
			{"34","[______]","35","36","37"},
			{"41","[______]","40","39","38"},
			{"42","[______]","43","44","45"},
			{"49","[______]","48","47","46"},
			{"50","[______]","51","52","53"},
			{"57","[______]","56","55","54"},
			{"58","[______]","59","60","61"},
			{"62","[______]","[__]","[__]","[__]"},
			{"63","[______]","[__]","[__]","[__]"}
			};*/
		{
			{"[01]","[______]","[_L]","[_M]","[_U]"},
			{"[02]","[______]","[03]","[04]","[05]"},
			{"[09]","[______]","[08]","[07]","[06]"},
			{"[10]","[______]","[11]","[12]","[13]"},
			{"[17]","[______]","[16]","[15]","[14]"},
			{"[18]","[______]","[19]","[20]","[21]"},
			{"[25]","[______]","[24]","[23]","[22]"},
			{"[26]","[______]","[27]","[28]","[29]"},
			{"[33]","[______]","[32]","[31]","[30]"},
			{"[34]","[______]","[35]","[36]","[37]"},
			{"[41]","[______]","[40]","[39]","[38]"},
			{"[42]","[______]","[43]","[44]","[45]"},
			{"[49]","[______]","[48]","[47]","[46]"},
			{"[50]","[______]","[51]","[52]","[53]"},
			{"[57]","[______]","[56]","[55]","[54]"},
			{"[58]","[______]","59","60","[61]"},
			{"[62]","[______]","[_L]","[_M]","[_U]"},
			{"[63]","[______]","[_A]","[_M]","[_W]"}
			};
	
		
		String[] wait= {"[1]","[2]","[3]","[4]","[5]",
						"[6]","[7]","[8]","9","10"};
	int PNR_NO=000000001;
	while(true) {	
	ShowSeats(Tickets);
	Check check =new Check();
	int confirmseats=0;
	confirmseats=check.BalenceConfirmSeatCount(Tickets);
	System.out.println("\n\nAvailable Seats: "+confirmseats);
	
	System.out.print("Enter how many ticket you want");
	int persons=scan.nextInt();
	int waitingseats=persons-confirmseats;
	int waitavail=check.BalenceWaitSeatCount(wait);
	if (confirmseats>=persons) {
	Book book=new Book();
	book.confirmbook(Tickets,persons);}
	
	else if( waitavail>=waitingseats) {System.out.println("there is only "+confirmseats+" confirmseats available"
			+ "\nif you want to proceed balence "+waitingseats+" with waitinglist "
			+"\npress 1 or want to quit press 2");
	while(true) {
	int n=scan.nextInt();
	if(n==1) {	
		Book book=new Book();
		if(confirmseats>0) {
			book.confirmbook(Tickets,(confirmseats));}
			book.waitingbook(wait,waitingseats);
	break;}
	else if(n==2) {System.out.print("Thank you");break;}
	else {System.out.println("please press 1 or 2 only");}
	}}
	else {System.out.println("there is no available tickets for "+waitingseats+" waiting seats");}
	
	System.out.println("if you want to quit the website press 0 "
			+ "\nor want to continue press any number");
	System.out.print(PNR_NO);
	int inp=scan.nextInt();
	if(inp==0) {break;}
	}
	}

}
