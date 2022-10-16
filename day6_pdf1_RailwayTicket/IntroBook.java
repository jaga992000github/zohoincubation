package day6_pdf1_RailwayTicket;
import java.util.*;
public class IntroBook {
	static Scanner scan =new Scanner(System.in);
	static void intro(String[][]Tickets,String[] wait,int PNR_NO) {
		Check check =new Check();
		int confirmseats=0;
		confirmseats=check.BalenceConfirmSeatCount(Tickets);
		int waitavail=check.BalenceWaitSeatCount(wait);
	System.out.print("Enter how many ticket you want: ");
	int persons=scan.nextInt();
	int waitingseats=persons-confirmseats;
	if (confirmseats>=persons) {
	Book book=new Book();
	book.confirmbook(Tickets,persons);
	System.out.println("your PNR NO is "+PNR_NO+"\n");}
	
	else if( waitavail>=waitingseats) {System.out.println("there is only "+confirmseats+" confirmseats available"
			+ "\nif you want to proceed balence "+waitingseats+" with waitinglist "
			+"\npress 1 or want to quit press 2");
	while(true) {
	int n=scan.nextInt();
	if(n==1) {	
		Book book=new Book();
		if(confirmseats>0) {
			book.confirmbook(Tickets,(confirmseats));}
			book.waitingbook(wait,waitingseats,persons);
			System.out.println("your PNR NO is "+PNR_NO+"\n");
			break;}
		else if(n==2) {System.out.print("Thank you");break;}
		else {System.out.println("please press 1 or 2 only");}
	}}
	else {int n =check.BalenceWaitSeatCount(wait);
	System.out.println("there is only "+n+" waiting seats available");}}
	

}
