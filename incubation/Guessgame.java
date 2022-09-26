//guess game
package incubation;
import java.util.*;
public class Guessgame {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n = 25;
		while( true){
			System.out.println("enter the guess:");
			int num =scan.nextInt();
			if(num==n) {
				System.out.println("Hurray thats the number");
				break;
			}
			else if(num>n) {
				System.out.println("too long try anather number");
			}
			else if(num<n) {
				System.out.println("too short try anather number");
			}
		}
		
		
	}
}
