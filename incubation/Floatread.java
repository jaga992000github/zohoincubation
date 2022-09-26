//floating number
package incubation;
import java.util.*;
public class Floatread {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the float no:");
		float num = scan.nextFloat();
		if(num==0) {System.out.println("zero");}
		
		if(num>0) {System.out.println("positive");}
		
		else {System.out.println("Negative");}
		
		if(-1.5<num && num<1.9) {System.out.println("small");}
		
		if(num>1000000) {System.out.println("big");}
	}

}
