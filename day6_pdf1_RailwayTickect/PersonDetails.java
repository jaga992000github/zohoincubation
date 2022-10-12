package day6_pdf1_RailwayTickect;
import java.util.*;
public class PersonDetails extends Main{
	Scanner scan=new Scanner(System.in);
	Main m=new Main();
	int pnrno=m.PNR_NO-1;
	String name;
	int age;
	String AGE;
	String gender;
	String seatNo;
	
	/*public PersonDetails(String name,int age,String gender,String seatNo)
	{
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.seatNo=seatNo;
	}
	
	public PersonDetails() {
		
	}*/

	void scan(int k) {		
				
		System.out.print("\nEnter the person("+k+") Name: ");
		name=scan.next().trim();
		PD[pnrno][k-1][0]=name;
		System.out.print("\nEnter the person("+k+") Age: ");
		age =scan.nextInt();
		AGE=String.valueOf(age);
		PD[pnrno][k-1][1]=AGE;
		System.out.print("\nEnter the person("+k+") Gender: ");
		gender=scan.next().trim();
		PD[pnrno][k-1][2]=gender;
		
		//PersonDetails pd = new PersonDetails(name,age,gender,seatNo);
		//int j=k-1;
		//PDdata[pnrno][j]=pd;
		
	}
	
	void print(int k) {
		int j=k-1;
		System.out.println("person("+k+") name :"+PD[pnrno][j][0]);//PDdata[pnrno][j].name);
		System.out.println("person("+k+") Age :"+PD[pnrno][j][1]);//PDdata[pnrno][j].age);
		System.out.println("person("+k+") Gender :"+PD[pnrno][j][2]);//PDdata[pnrno][j].gender);
		
	}
	//PersonDetails PDdata [][] =new PersonDetails[63][63];
	void PrintTickets() {
		int PNR=1;
		for(int i=0;i<20;i++) {
			System.out.println("PNR NO "+PNR);
			for(int j=0;j<PD[0].length;j++) {
				if(PD[i][j][0]==null) {break;}
					System.out.println("\nName: "+PD[i][j][0]);
					System.out.println("Age: "+PD[i][j][1]);
					System.out.println("Gender: "+PD[i][j][2]);
					System.out.println("Ticket: "+PD[i][j][3]+"\n");
			}System.out.println("_____________________________");
			PNR+=1;
		}
	}
}
