//postive integer arrayb occurence count
package day2pdf_1;
import java.util.*;
public class Occurrences {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the array size");
	int size=scan.nextInt();
	System.out.println("Enter the array nums");
	int[] nums= new int[size];	
	for(int i=0;i<size;i++) {
		nums[i]=scan.nextInt();
	}

	for(int i=0;i<size;i++) {
		int occ=0;
		for(int j=0;j<size;j++) {
			if(nums[i]==nums[j]) {
				occ+=1;
				if (occ>1) {
					nums[j]=-1*nums[j];
				}
			}
		}
		if(nums[i]>0 )
		{System.out.println(nums[i]+"-"+ occ);}
	}	
}
}
