package day2pdf_1;
import java.util.*;
public class PrimenoTwist {
public static int primecheck(int x) {
	int i=2;
	int ans=1;//to check it is a prime or not
	while (i<x){
		if(x%i==0) {
			ans=0;
			break;
		}i+=1;
	}return ans;
}
public static int swap(int x) {
	int rem=1,div=0,ans=0;
	while(x>0) {
		rem=x%10;
		ans=ans*10+rem;
		x=x/10;
	}return ans;
}
	
	
	
	
	
	
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n=scan.nextInt();
	int primeresult= primecheck(n);
	int swapresult= swap(n);
	int swapprimecheck=primecheck(swapresult);
	if ((primeresult==1)&&(swapprimecheck==1)) {
		System.out.println("true");
	}else {System.out.println("false");}
}
}
