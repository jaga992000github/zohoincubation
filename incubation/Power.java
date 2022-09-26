//two number power
package incubation;
import java.util.*;
public class Power {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the two numbers:");
		int x =scan.nextInt();
		int y =scan.nextInt();
		int i=1;
		int temp=x;
		while(i<y) {
			x*=temp;
			i+=1;
		}
		System.out.println("square value is: "+x);
	}

}
