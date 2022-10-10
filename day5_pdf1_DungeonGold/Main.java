package day5_pdf1_DungeonGold;
import java.util.*;
class Main extends DSP {
	
	public static void main (String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("Enter row");
	int row=scan.nextInt();
	System.out.println("Enter col");
	int col=scan.nextInt();
	System.out.println("Select the level from 1 to 7");
	int level = scan.nextInt();	
	char[][] m=new char[row][col];
	
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++ ) {
				m[i][j]='-';}}
		
		
		char[][] ans= {{}};
		
		switch(level) {
		case 1:
			Level_1 result1=new Level_1(); 
			ans=result1.L1(m);break;
		case 2:
			Level_2 result2=new Level_2(); 
			ans=result2.L2(m);break;
		case 3:
			Level_3 result3=new Level_3(); 
			ans=result3.L3(m);break;
		case 4:
			Level_4 result4=new Level_4(); 
			ans=result4.L4(m);break;
		default:
			System.out.print("Please try with level between 1 to 7");
		}
		
		
		
		
		
		for(int u=0;u<row;u++) {
			for(int v=0;v<col;v++ ) {
				System.out.print(ans[u][v]+" ");
				}System.out.println();
			}
	}

}
