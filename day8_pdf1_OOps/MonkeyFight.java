package day8_pdf1_OOps;
import java.util.*;
public class MonkeyFight {
	static int secMI=0;//second maximum index for monkey 2
	public static int findMaxIndex(int[] trees) {
		int max=0,maxindex=0;
		int size=trees.length;
		max=trees[0];
		for(int i=0;i<size;i++) {
			if(max<trees[i]) {
					max=trees[i];
					maxindex=i;
				}
			}
		return maxindex ;
	}
	
	
	static int maxpath(int [] trees,int MI) {
		int ans=0;
		int size=trees.length;
		int path=0; 
		
		
		int	maxHighPath=0;//max distance from second monkey tree to first monkey ground	System.out.println("Enter size of each trees");	
		int MHPans=0;
		
		if(path<0) {path*=-1;}
		path=MI-0;
		maxHighPath=path+trees[0];
		for(int i=0;i<size;i++) {
			path=MI-i;
			if(path<0) {path*=-1;}
			if(maxHighPath<path+trees[i]) {
				maxHighPath=path+trees[i];
				secMI=i;
				MHPans=maxHighPath;
			}
		}ans=MHPans;
		return ans;
	}
	
	
	public static void main(String[]args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter no of trees");
	int size =scan.nextInt();
	int ans=0;
	
	
	int[] trees=new int[size];
	System.out.println("Enter the tree high");
	for(int i=0;i<size;i++) {
		trees[i]=scan.nextInt();}

	int MI =findMaxIndex(trees);//maximum index for monkey 1
	ans+=trees[MI];						//6 3 2 5 1 8 7 4
	int temp=trees[MI];					//5 2 4 1 5 5 3 4 3
	trees[MI]=0;
	
	ans+=maxpath(trees,MI);
	
	
	System.out.println("1st monkey tree no("+(MI+1)+")= "+temp+" feet");
	System.out.println("2st monkey tree no("+(secMI+1)+")= "+trees[secMI]+" feet");
	System.out.println("Max Distance between them "+ans);
}
}
