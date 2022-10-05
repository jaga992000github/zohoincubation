//To count how many vowels present in the Given string
package day4pdf_1;
import java.util.*;
public class VowelCount {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("Enter the String");
	String s=scan.next();
	int count=0;
	char[] c= {'a','e','i','o','u','A','E','I','O','U'};
	for(int i=0;i<s.length();i++) {
		for(int j=0;j<c.length;j++) {
			if(s.charAt(i)==c[j]) {
				count+=1;break;
			}
		}
	}System.out.print(count);
	
}
}
