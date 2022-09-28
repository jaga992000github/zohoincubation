package day3pdf_1;
import java.util.*;
public class DuplicateStrSort {
public static char[] swap(char[] x) {
	for(int i=0;i<x.length-1;i++) {
		if(x[i]>x[i+1]) {
			char temp=x[i+1];
			x[i+1]=x[i];
			x[i]=temp;
		}}return(x);
}
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	String str=scan.next();
	char[] s= new char[str.length()];
	for(int i=0;i<str.length();i++) {
		s[i]=str.charAt(i);
	}
	char[] c=new char[s.length];
	for(int i=0;i<s.length;i++) {
		for(int j=i+1;j<s.length;j++) {
			if(s[i]==s[j]) {
			s[j]='*';	
			}if(s[i]!='*') {
				c[i]=s[i];
			}
		}
	}char[] ans=swap(c);
	int i=0;
	while(i<c.length-1) {
		if(c[i]>c[i+1]) {
		ans=swap(ans);
		
		}i++;
	}
	
	for(int j=0;j<ans.length;j++) {
		if(ans[i]!=' ') {
		System.out.print(ans[j]);}
	}
}
}
