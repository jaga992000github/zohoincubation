package day5_pdf1_DungeonGold;
import java.util.*;
public class Level_3 {
	public static char[][] L3(char[][] m) {
		Scanner scan=new Scanner(System.in);
		Main dsp=new Main();
		
		System.out.println("Enter gold position");//g pos
		int Gi=scan.nextInt();Gi-=1;
		int Gj=scan.nextInt();Gj-=1;
		char Obj='G';
		m=dsp.InsertObj(Gi, Gj, m, Obj);
		
		System.out.println("Enter adventure man position");//A pos
		int Ai =scan.nextInt();Ai-=1;	
		int Aj =scan.nextInt();Aj-=1;
		Obj='A';char Apath='$';
		m=dsp.InsertObj(Ai, Aj, m, Obj);
		m=dsp.ShortestPath(Ai, Aj, Gi, Gj, m, Apath);
		int Asteps=dsp.CountSteps(m, Apath);
		
		System.out.println("Enter Monster position");//M pos
		int Mi =scan.nextInt();Mi-=1;	
		int Mj =scan.nextInt();Mj-=1;
		Obj='M';char Mpath='#';
		m=dsp.InsertObj(Mi, Mj, m, Obj);
		m=dsp.ShortestPath(Mi, Mj, Gi, Gj, m, Mpath);
		int Msteps=dsp.CountSteps(m, Mpath);
		
		if(Asteps>=Msteps) {
			System.out.println("\n\nNo possible moves\nMonster Wins!!\n\n");}
		
		else {System.out.println("\n\nAdventure wins by Steps: "+Asteps+"\n\n");
				m=dsp.ShortestPath(Ai, Aj, Gi, Gj, m, Apath);
				for(int i=0;i<m.length;i++) {
					for(int j=0;j<m[0].length;j++) {
						if(m[i][j]=='$') {
							System.out.print("("+i+","+j+")->");
						}
					}
				}System.out.print("\n\n");
		}
	return m;}
}	
