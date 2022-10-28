package day9_DiwaliQuestions;
import java.util.*;
public class Q1_RainWaterTrap {
	
	public static void main(String[]args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no of walls and gaps");
		int size=scan.nextInt();
		System.out.println("Enter the feets of wall");
		int [] feet=new int[size];
		for(int i=0;i<size;i++) {
			feet[i]=scan.nextInt();
		}
		int gap=0;
		int start=feet[0],startindex=0;
		for(int i=1;i<size;i++) {
			if (feet[i]>start&&i!=size-1) {//3 0 0 7(startindex) 0 9
				start=feet[i];
				startindex=i;
			}
			if(feet[i]<=start) {//3 0 0 2 0 4
				gap+=start-feet[i];
			}
		}if(startindex!=0&&start>feet[size-1]) {//3 0 0 7  2 1
			int count=0;
			for(int i=size-1;i>startindex;i--){
				count+=1;
			}gap-=count*(start-feet[size-1]);
		}if(startindex==0&&start>feet[size-1]) {//4 3 2 1
			gap=0;
		}
		System.out.print(gap);
	}
}
