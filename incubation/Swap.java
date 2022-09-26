//swap numbers
package incubation;
import java.util.*;
public class Swap {
	public static void main(String[] args) {
		System.out.print("Enter two nums:" );
		Scanner scan = new Scanner(System.in);
		int num_1 = scan.nextInt();
		int num_2 = scan.nextInt();
		int temp = num_1;
		num_1 = num_2;
		num_2 = temp;
		System.out.print("nums after swapped:\n" );
		System.out.print(num_1 + " "+ num_2);
	}
}
