package day9_DiwaliQuestions;
import java.util.*;
public class Q21_nextBigNo {
	static Scanner scan =new Scanner(System.in);
	
	static {
		
		
	}public static void main(String[] x) {
		System.out.println("Enter the size of the array");
		int n=scan.nextInt();
		System.out.println("Enter the elements of the array");
		int[]arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scan.nextInt();
		}for(int i=0;i<n;i++) {
			if(i<(n-1)) {
				if(arr[i+1]>arr[i]) {
					System.out.print(arr[i+1]+" ");
				}}
		}
	}
}
