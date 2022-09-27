//print words in right angle down triangle
package day2pdf_1;
import java.util.*;
public class DownCrossWords {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the string");
	String str=scan.next();
	int u=0,n=str.length()/2;
	for(int i=str.length()-1;i>=0;i--) {
		for(int j=i;j>0;j--) {
			System.out.print("  ");
			}for(int k=0;k<=u&&u<=str.length();k++){
				if(n>str.length()-1) {n=0;}//redirect to start
				System.out.print(str.charAt(n));
				n+=1;
			}u+=1;//char row wise column 
		System.out.println();
		}
}
}
//PROGRAM