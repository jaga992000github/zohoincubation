package day6_pdf1_RailwayTickect;
import java.util.*;
class Main {
	static int PNR_NO;
	static String[][][] PD=new String[63][63][4];
	static String[][]Tickets=
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
			{"[58]","[______]","[59]","[60]","61"},
			{"[62]","[______]","[_L]","[_M]","[_U]"},
			{"[63]","[______]","[_A]","[_M]","[_W]"}
			};
	static String[] wait= {"[1]","[2]","[3]","[4]","[5]",
			"[6]","[7]","8","9","10"};
	
	static void ShowSeats(String[][] Tickets,String[]wait) {
		System.out.println("Confirm seats \n");
		for(int i=0;i<Tickets.length;i++) {
			for(int j=0;j<Tickets[0].length;j++) {
				System.out.print(Tickets[i][j]+" ");
			}System.out.println();
			if(i%2==0) {System.out.println();}
		}
		System.out.print("\n\nWaiting List");
		System.out.println("\n");
		for(int i=0;i<wait.length;i++) {
			System.out.print(wait[i]+" ");
			if(i==4) {System.out.println();}
		}
	}
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
	PNR_NO=1;
	while(true) {	
	ShowSeats(Tickets,wait);
	Check check =new Check();
	int confirmseats=0;
	confirmseats=check.BalenceConfirmSeatCount(Tickets);
	int waitavail=0;
	waitavail=check.BalenceWaitSeatCount(wait);
	System.out.println("\n\nAvailable confirm Seats: "+confirmseats+"\nAvailable waiting list "+waitavail+"\n");
	

	System.out.println("To Booking press 1");
	System.out.println("To Cancel press  2");
	System.out.println("To Show DB 3");
	int n=scan.nextInt();
	
	while(true) {

	if(n==1) {
		IntroBook IB=new IntroBook();
		IB.intro(Tickets,wait,PNR_NO);
		break;}
	else if(n==2) {
		Cancel cancel=new Cancel();	
		cancel.cancel(Tickets,wait);
		break;}
	else if(n==3) { 
		PersonDetails pd=new PersonDetails();
		pd.PrintTickets();break;}
		else {
		System.out.println("press from 1 to 3 only");
		break;
		}
	}
	
	System.out.println("\nfor Quit press 0\nfor continue press any key");
	int inp=scan.nextInt();
	if(n==1) {
	PNR_NO+=1;}
	if(inp==0) {break;}
	}
	
	}

}
