package day7_pdf1_task5;
import java.util.*;
public class SumTarget {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[]args) {
	System.out.println("Enter the array size");
	int size=scan.nextInt();
	System.out.println("Enter the target");
	int target=scan.nextInt();
	int[] nums=new int[size];
	System.out.println("Enter the matrix values");
	for(int i1=0;i1<size;i1++) {
		nums[i1]=scan.nextInt();
	}	
		int min=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				for(int k=0;k<size;k++) {
					if(i!=j&&j!=k&&k!=i) {
						int sum=nums[i]+nums[j]+nums[k];
						if((sum-target)<3&&(sum-target)>0){
							min=sum;
							if(sum<min) {
								min=sum;
							}
							
							//System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
						}
					}
				}
			}
		}System.out.println(min);
	
	}
}
