//illustrate data type range
package incubation;
import java.util.*;
public class DataTypeSize {
	public static void main(String[] args) {
		System.out.println("byte-1\nshort-2\nint-3\nlong-4\nfloat-5\ndouble-6");
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the value of data types:");
		int dtnum=scan.nextInt();
		switch (dtnum) {
		case 1:
		    System.out.println("The range is " + Byte.MIN_VALUE +" to "+ Byte.MAX_VALUE);break;
		case 2:
		    System.out.println("The range is " + Short.MIN_VALUE +" to "+ Short.MAX_VALUE);break;
		case 3:
		    System.out.println("The range is " + Integer.MIN_VALUE +" to "+ Integer.MAX_VALUE);break;
		case 4:
		    System.out.println("The range is " + Long.MIN_VALUE +" to "+ Long.MAX_VALUE);break;
		case 5:
			System.out.println("The range is " + Float.MIN_VALUE +" to "+ Float.MAX_VALUE);break;
		case 6:
			System.out.println("The range is " + Double.MIN_VALUE +" to "+ Double.MAX_VALUE);break;
		default:
			System.out.println("Try with given numbers only");
		
		}
	}

}
