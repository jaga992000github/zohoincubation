//To print the middle char of a string
package day4pdf_1;
import java.util.*;
public class MiddleChar {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("Enter the string:");
	String s=scan.next();
	if(s.length()%2==0) {
		System.out.print(s.charAt(s.length()/2)+""+s.charAt((s.length()/2)-1));
	}else {System.out.print(s.charAt((s.length()/2)));}
}
}
