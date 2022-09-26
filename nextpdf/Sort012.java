// sort 0 1 2
package nextpdf;
import java.util.*;

public class Sort012 {
	public static int[] swap(int[] x) {
		Scanner scan = new Scanner(System.in);
		int temp=0;
		for(int j=0;j<x.length-1;j++) {
		if(x[j]>x[j+1]) {
			temp=x[j];
			x[j]=x[j+1];
			x[j+1]=temp;}
		}
		return x;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the size of the array");
	int size = scan.nextInt();
	int[] nums= new int[size];
	int count=0;
	System.out.println("please enter the values of the array");
	for(int i=0;i<size;i++) {
		nums[i]=scan.nextInt();
	}
	int [] result = swap(nums);
	int k=0;
	while(k<size-1){
		if(result[k]<result[k+1]) {
			k+=1;
		}if(k==size-2) {System.out.println(Arrays.toString(result));break;}
		else {result=swap(result);}
		
	}
		
				
	}


}
