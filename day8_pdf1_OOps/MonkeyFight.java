package day8_pdf1_OOps;
import java.util.*;
public class MonkeyFight {

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
	
	public static void main(String[]args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter no of trees");
	int size =scan.nextInt();
	int ans=0;
	int path=0, 
			MI=0,//maximum index for monkey 1
			secMI=0,//second maximum index for monkey 2
			maxHighPath=0;//max distance from second monkey tree to first monkey ground
	System.out.println("Enter size of each trees");	
	int[] trees=new int[size];
	
	for(int i=0;i<size;i++) {
		trees[i]=scan.nextInt();}

	MI =findMaxIndex(trees);
	ans+=trees[MI];						//6 3 2 5 1 8 7 4
	
	maxHighPath=path+trees[0];
	for(int i=0;i<size;i++) {
		path=MI-i;
		if(path<0) {path*=-1;}
		if(maxHighPath<path+trees[i]) {
			maxHighPath=path+trees[i];
			secMI=i;
			ans+=maxHighPath;
		}
	}
	
	
	System.out.println("1st monkey tree no("+(MI+1)+")= "+trees[MI]+" feet");
	System.out.println("2st monkey tree no("+(secMI+1)+")= "+trees[secMI]+" feet");
	System.out.println("Max Distance between them "+ans);
}
}
