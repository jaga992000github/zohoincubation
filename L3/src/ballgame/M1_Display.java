package ballgame;
import java.util.*;
public class M1_Display {
	static Scanner scan=new Scanner(System.in);
	static String[][] area=new String[7][7];
	static int ballcount=0;
	static int[] ballpos= {0,0};
	
	static void arange() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				area[i][j]=" ";
			}
		}
		for(int i=0;i<7;i++) {
			area[i][0]="W";//left wall
			area[i][7-1]="W";//right wall
		}
		for(int j=1;j<7-1;j++) {
			area[0][j]="W";//top wall
		}
		for(int j=1;j<7-1;j++) {
			area[7-1][j]="G";//ground
		}
		area[7-1][3]="o";
		ballpos[0]=5;
		ballpos[1]=3;
	}
	
	public static  void brick() {
		/*while (true) {
			int cont=1;
			if(cont==1) {
			System.out.println("enter brick position and type");
			int i=scan.nextInt();
			int j=scan.nextInt();
			String type=scan.next();
			area[i][j]=type;
			cont=0;}
			System.out.println("want to continue\n"
					+ "1 for yes and 0 for no :");
			cont=scan.nextInt();
			if(cont==0) {
				System.out.println("Enter ball count");
				ballcount=scan.nextInt();
				break;
			}
		}*/area[2][2]="1";area[2][3]="3";area[2][4]="1";ballcount=3;
		   area[3][2]="2";area[3][3]="2";area[3][4]="1";
	}
	static void display() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(area[i][j]+" ");
			}System.out.println();
		}System.out.println(ballcount);
	}

}
