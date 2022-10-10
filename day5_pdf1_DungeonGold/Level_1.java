package day5_pdf1_DungeonGold;
import java.util.*;
public class Level_1 {
	public static char[][] L1(char[][] m) {
		Scanner scan=new Scanner(System.in);
		Main dsp=new Main();
		
		System.out.println("Enter adventure man position");//Ai pos
		int Ai =scan.nextInt();Ai-=1;	
		int Aj =scan.nextInt();Aj-=1;
		char Obj='A',path='$';
		m=dsp.InsertObj(Ai, Aj, m, Obj);
		
		System.out.println("Enter gold position");//g pos
		int Gi=scan.nextInt();Gi-=1;
		int Gj=scan.nextInt();Gj-=1;
		Obj='G';
		m=dsp.InsertObj(Gi, Gj, m, Obj);
		m=dsp.ShortestPath(Ai, Aj, Gi, Gj, m, path);
		
		int steps=dsp.CountSteps(m, path);
		System.out.println("\n\nSteps required: "+steps+"\n\n");
		return m;
	
	}
}
