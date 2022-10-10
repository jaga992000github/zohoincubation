package day5_pdf1_DungeonGold;
import java.util.*;
public class Level_4 {
	public static char[][] L4(char[][] m) {
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
		
		System.out.println("Enter Triger position");//T pos
		int Ti =scan.nextInt();Ti-=1;	
		int Tj =scan.nextInt();Tj-=1;
		Obj='T';char Tpath='*';
		m=dsp.InsertObj(Ti, Tj, m, Obj);
		
		int TGsteps=0,Tsteps=0;
		
		if(Asteps>=Msteps) {
			m=dsp.ShortestPath(Ai,Aj,Ti,Tj,m,Tpath);
			Tsteps=dsp.CountSteps(m, Tpath);
				if(Tsteps<Msteps) {
					m=dsp.ShortestPath(Ti,Tj,Gi,Gj,m,Tpath);
					TGsteps=dsp.CountSteps(m, Tpath);
		System.out.print("\n\nAdventure wins by steps: "+TGsteps+"\n\n");}
		
				else{System.out.print("\n\nMonster wins\n\n");}	
		}else {System.out.print("\n\nAdventure wins by steps: "+Asteps+"\n\n");}
	return m;}
}	

