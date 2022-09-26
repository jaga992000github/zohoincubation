//odd numbers and sum
package incubation;
import java.util.*;
public class Oddsum {
	public static void main(String[] args) {
		System.out.println("enter the order:");
		Scanner scan =new Scanner(System.in);
		int num = scan.nextInt();
		int sum=0;
		int i=1;
		int j=1;
		while(j<=num) {
			sum +=i;
			System.out.println(i);
			j+=1;
			i+=2;
		}
		System.out.println("sum="+sum);
	}	
		
}
