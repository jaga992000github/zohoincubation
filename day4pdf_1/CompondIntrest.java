package day4pdf_1;
import java.util.*;
public class CompondIntrest {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the principal amount");
		double p=scan.nextDouble();
		System.out.println("enter the Intrest amount");
		double r=scan.nextDouble();
		System.out.println("enter the no of years");
		double n=scan.nextDouble();
		double ans=0;
		for(int i=1;i<=n;i++) {
		double pow=Math.pow((1+(r/1200)),12*i);
		ans=p*pow;
		System.out.println("year "+'('+i+')'+""+ans);}
	}
}
