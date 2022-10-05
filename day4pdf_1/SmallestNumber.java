//to find smallest among 3 nums
package day4pdf_1;
import java.util.*;
public class SmallestNumber {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter three numbers");
		double x,y,z;
		x=scan.nextDouble();
		y=scan.nextDouble();
		z=scan.nextDouble();
		if(x<y&&x<z) {
			System.out.print("the smallest value is: "+x);
		}else if(z<y&&z<x) {
			System.out.print("the smallest value is: "+z);
		}else {System.out.print("the smallest value is: "+y);}
	}
}
