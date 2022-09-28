//string iteration
package day3pdf_1;
import java.util.*;
public class StringintTimes {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the number of iteration");
	int n=scan.nextInt();
	System.out.println("enter the string");
	String s=scan.next();
	for(int i=0;i<n;i++) {
		System.out.print(s);
	}
}
}
