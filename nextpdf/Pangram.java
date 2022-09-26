//panagram
package nextpdf;
import java.util.*;
public class Pangram {	
	//abcdefghijklmnopqrstuvwxyz	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter the string");
		String str=scan.nextLine();
		if(str.length()<26) {
			System.out.println("0");}
		else {
		char i=65;
		int count= 0;
		int ans= 0;
		while(i < 122) {
			int j=0;
			while(j<str.length()) {
				if(i==str.charAt(j)) 
				{count+=1;
				ans=1;
				break;}
				else if(j==str.length()-1 && ans==0) {
					ans=0;
					break;
				}
				else {j+=1;}
				};
			i+=1;
		}
		if(count<=26) {
		System.out.println(ans);}}
	}
}
