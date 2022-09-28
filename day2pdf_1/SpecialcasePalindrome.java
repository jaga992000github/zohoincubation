package day2pdf_1;
import java.util.*;
public class SpecialcasePalindrome {
public static void main(String args[]) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the string");
	String line=scan.nextLine();
	int i=0, j=line.length()-1;
while(i<line.length() && j>=0){//to check there is any special charecters
	if((line.charAt(i)<=97 || line.charAt(i)<=122)&&(line.charAt(j)<=97 || line.charAt(j)<=122)) {
		if(line.charAt(i)==line.charAt(j)) {
		if(i==line.length()-1 && j==0) 
		{System.out.println("its a palindrome");break;}
		i+=1;
		j-=1;}
	else {System.out.println("not a palindrome");break;}	
	}}
}
}