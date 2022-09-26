package day2pdf_1;
import java.util.*;
public class DoubletZeroSort {

	static int[] doublecheck(int[] x) {
		int inc=1;
		for(int i=0;i<x.length-1;i+=inc) {
			if(x[i]==x[i+1]) {
				x[i]=2*x[i];
				x[i+1]=0;
				inc=2;
			}else {inc=1;}
			
		}return(x);
	}static int[] swap(int[] y) {
		int temp=0;
		for(int i=0;i<y.length-1;i++) {
			if(y[i]==0) {
			temp=y[i];
			y[i]=y[i+1];
			y[i+1]=temp;
			}
		}return(y);
		
	}
	
	
	
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in); 
	System.out.println("Enter the size of array");
	int size = scan.nextInt();
	int nums[]= new int[size];
	System.out.println("Enter the numbers of array");
	int inp; 
	for(int inpno=0;inpno<size;inpno++) {
		inp=scan.nextInt();
		nums[inpno]=inp;
	}
	int[] result=doublecheck(nums);
		int i=0;
		while(i<size-2) {
		if(result[i]==0 && result[i+1]!=0) {
			result=swap(result);}
		else{i+=1;}
		}
		System.out.println(Arrays.toString(result));
}
}
