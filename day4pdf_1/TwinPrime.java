//to print the twin prime numbers between 1 to 100 
package day4pdf_1;
import java.util.*;
public class TwinPrime {
	public static int primecheck(int x) {
		int presence=1;
		for(int i=2;i<x;i++) {
			if(x%i==0) {
				presence=0;
			}
		}return presence;
	}
	public static void main(String[] args) {
		
		for(int i=2;i<=100;i++) {
			int in=0;
			in=primecheck(i);
		if(in==1) {
			in=primecheck(i+2);
			if(in==1) {System.out.println("("+i+','+(i+2)+")");in=0;}
		}
		}
}
}
