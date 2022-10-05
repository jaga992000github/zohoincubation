//program to count the words in a program
package day4pdf_1;
import java.util.*;
public class WordsCount {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("enter the string");
	String s=scan.nextLine();
	int count=1;
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)==' ') {
			count+=1;
		}
	}System.out.print(count);
}
}
