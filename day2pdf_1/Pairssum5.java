package day2pdf_1;
import java.util.*;
public class Pairssum5 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter the size of the array");
		int size = scan.nextInt();
		int[] nums=new int[size];
		System.out.println("please enter the values of the array");
		for(int i=0;i<size;i++) {
			nums[i]=scan.nextInt();}
		int paircount=0;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(nums[i]+nums[j]==5) {
					paircount+=1;
					System.out.println("("+nums[i]+","+nums[j]+") ");
				}
			}
		}System.out.print("pairs that sums 5 is "+ paircount);
	}
}
