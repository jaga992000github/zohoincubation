// string rotation
package nextpdf;
import java.util.*;
public class Stringrotation {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("please enter the strings to be check");
		String a=scan.next();
		String b= scan.next();
		char[] str=a.toCharArray();

		char temp =0;

		int k=0;
		while(k<2) {	
			temp =str[0];
			int i=0;
			int j=1;
			while(i< str.length-1 && j <str.length) {
				str[i]=str[j];
				i++;
				j++;
			}
			str[str.length-(1)]=temp;
			k+=1;		
		}
		int ans=1;
		for(int i = 0; i<str.length;i++) {
			if(str[i] != b.charAt(i)) {
				ans = 0;
			}
		}

		System.out.println(ans);
		

	}
}
