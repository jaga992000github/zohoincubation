//10s multiply
package incubation;
import java.util.Scanner;

public class Multiply {

	public static void main(String[] args) {
		System.out.println("enter the number to be multiply:");
		Scanner scan=new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 1;i<11;i+=1) {
			System.out.println(i +"*"+num+" = "+ i*num);
		}
		
	}

}
