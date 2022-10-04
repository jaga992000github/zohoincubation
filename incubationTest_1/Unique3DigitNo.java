//to print the unique numbers
package incubationTest_1;
import java.util.*;
public class Unique3DigitNo {
public static void main(String[] args) {
	int n[]= {1,2,3,4};
	int temp=0;
	int count=1;
	for(int j=0;j<n.length-1;j++) {
		System.out.print(n[j]+" ");
	}System.out.print("("+count+")");;count+=1;
	System.out.println();
	while(count<24)
	for(int i=n.length-1;i>0&&count<=24;i--) {
		temp=n[i];
		n[i]=n[i-1];
		n[i-1]=temp;
		for(int j=0;j<n.length-1;j++) {
			System.out.print(n[j]+" ");
		}System.out.print("("+count+")");count+=1;
		System.out.println();
	}
}
}
