//reverse string
package nextpdf;
import java.util. *;
public class Phraserev {
	static void strout(int x,int y,String z) {
		for(int j=x;j<y;j++) {
			System.out.print(z.charAt(j));
		}System.out.print(" ");
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the string");
		String str= scan.nextLine();
		int count=0;
		for(int i=(str.length())-1;i>=0;i--) {
		if((str.charAt(i)==' ')||(i==0)) {
			int start=i+1;
			if(i==0) {start=i;}
			strout(start,i+count+1,str);
			count=-1;	
				}
		count+=1;
			}
		
		}
	}
