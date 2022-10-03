package day2pdf_1;
import java.util.*;
public class StringDictiononary {
public static int check(String x) {
	String[] dict= {"i","like","sam","sung","samsung","mobile",
			"ice","cream","icecream","man","go","mango"};
	System.out.println(x);
	int presence=0;
	for(int i=0;i<dict.length;i++) {
		if(x.equals(dict[i])) {
			 presence=1;break;	
		}else {presence=0;}
	}return presence;
	
}
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	String inp=scan.nextLine();
	int ans=0,start=0,end=1;
	String seperate="";
	for(int i=start;i<end&&i<inp.length();i++) {
		if(inp.charAt(i)==' ') {i+=1;}//to eliminate space
		seperate+=inp.charAt(i);
		ans=check(seperate);
		if(inp.charAt(i)=='i'&&inp.charAt(i+1)=='c'&&inp.charAt(i+2)=='e'&&ans==1)
			//to make recheck in i and ice 
		{seperate="i";start=i+1;end+=i+2;}
		else if(ans==1)//to remove founded words 
		{seperate="";start=i+1;end+=i+2;}
		else {end+=1;}
	}
	System.out.println(ans);
}
}