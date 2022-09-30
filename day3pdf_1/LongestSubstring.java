//to count how many duplicates of character
package day3_pdf1;
import java.util.*;
public class LongestSubstring {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the string:");
	String str=scan.next();
	char[] ch=new char[str.length()];
	for(int i=0;i<str.length();i++) {
		ch[i]=str.charAt(i);
	}
	int count=0,ans=0;
	for(int i=0;i<ch.length;i++) {
		char temp=ch[i];//to not change the i char to *
		for(int j=0;j<ch.length;j++) {
		if(temp==ch[j]&&ch[j]!='*') {
			count+=1;
			ch[j]='*';
			}
		}if(count>1) {ans+=count;count=0;}
	}System.out.println(ans);
}
}
