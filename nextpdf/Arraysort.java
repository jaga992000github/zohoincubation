//array sort
package nextpdf;
import java.util.*;
public class Arraysort {
	
	public static int[] swap(int[] x) {
		Scanner scan = new Scanner(System.in);
		int temp=0;
		for(int j=0;j<x.length-1;j++) {
		if(x[j]<0) {
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
		if(nums[i]>0) {count+=1;}
	}
	int [] result = swap(nums);
	
	boolean check = false;
	int k=0;
		while((k<=count)&&(check==false)){
			if(result[k]>0) {
				k+=1;
				if(k==count-1) {check=true;System.out.println(Arrays.toString(result));}
			}else {result=swap(result);}
			
			}	
	}
}
