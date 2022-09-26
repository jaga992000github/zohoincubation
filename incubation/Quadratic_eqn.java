//Quadratic equation
package incubation;

import java.util.Scanner;

public class Quadratic_eqn {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("ax^2+bx+c\nplease enter the values of a,b,c");
		int a = scan.nextInt();
		int b =scan.nextInt();
		int c = scan.nextInt();
		
		double part1,part2;
		double sqr= (b^2)-(4*a*c);
		part1=(-b/(2*a));
		
		if(sqr>0) {
			part2=((Math.sqrt(sqr))/2*a);
			System.out.println(part1+" + or - "+part2);
		}else {
			sqr*=-1;
			part2=((Math.sqrt(sqr))/2*a);
			System.out.println("ans is: "+part1+" + or - "+"i"+part2);
		}
	}	
}
