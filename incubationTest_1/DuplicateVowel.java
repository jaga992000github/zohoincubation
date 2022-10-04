//to remove single vowel value in a given string
package incubationTest_1;
import java.util.*;
public class DuplicateVowel {
	public static int check (char x,int y) {
		int count = 0;
		char [] c= {'a','A','e','E','i','I','o','O','u','U'};
		for(int j=0;j<c.length;j++) {
		if(x==c[j]) {count=1;if(y>=1) {count+=y;break;}}
		else if(j==c.length-1&&count==0) {count=0;}
		}return count;
	}
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the string");
	String s=scan.next();
	String ans="";
	int present=0;
	for(int i=0;i<s.length();i++) {
		//pass present to check previous presence of vowels
		present=check(s.charAt(i),present);
		if(present==0) {ans+=s.charAt(i);}
		//to print non vowels  
		if(present==2) {ans+=s.charAt(i-1);ans+=s.charAt(i);}
		//to print more two vowels in order
		if(present>2) {ans+=s.charAt(i);}
		//to print more tha two vowels
	}System.out.print(ans);
}
}
