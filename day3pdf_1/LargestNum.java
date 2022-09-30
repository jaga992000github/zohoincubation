//enter an arrary and print possible maximum number from the  array
package day3_pdf1;
import java.util.*;
public class LargestNum {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the Array Size");
	int size=scan.nextInt();
	int[] n=new int[size];
	float[] nums=new float[size];//to store single value
	int [] ans=new int[size];
	System.out.println("Enter the Array nums");
	for(int i=0;i<size;i++) {
		float temp=scan.nextInt();
		n[i]=(int)temp;//to print 45 instead of 4.5
		while(temp>=10) {
			temp/=10;//for sort arangement we put decimal after first digit
		}nums[i]=temp;
		
	}int MaxIndex=0,maxans=0;
	for(int i=0;i<size;i++) {
		float max=nums[i];
		for(int j=0;j<size;j++) {// sort
			if(max<=nums[j]) {//search for max
				max=nums[j];
				MaxIndex=j;
			}
		}maxans=n[MaxIndex];
		nums[MaxIndex]=0;
		ans[i]=maxans;
	}for(int i=0;i<size-1;i++) {// to get change 10 s value and 1s val eg 30(3.0)and3(3.0)
		if(ans[i]%10==0&&ans[i+1]==ans[i]/10) {
			int temp=ans[i];
			ans[i]=ans[i+1];
			ans[i+1]=temp;
		}
	}for(int i=0;i<size;i++) {System.out.print(ans[i]);}
}
}//3 30 34 5 9
