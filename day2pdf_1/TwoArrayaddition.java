//two array(single digit)addition
package day2pdf_1;
import java.util.*;
public class TwoArrayaddition {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter size of 1st array");
		int size1=scan.nextInt();
		System.out.println("enter size of 2st array");
		int size2=scan.nextInt();
		int size =0,less=size2;
		if(size1>=size2) {
			size=size1;
		}else {size=size2;less=size1;}
		int[] a=new int[size];
		int[] b=new int[size];
		int count=size1-size2;//to calc how many zero in lesser array
		if(count<0) {count*=-1;}
		System.out.println("enter numbers of 1st array");	
		int start=0;
		if(less==size1) {start=count;}// to leave zero in lesser size array from starting
		for(int i=start;i<size;i++) {
			a[i]=scan.nextInt();
		}
		System.out.println("enter numbers of 2nd array");	
		start=0;
		if(less==size2) {start=count;}
		for(int j=start;j<size;j++) {
			b[j]=scan.nextInt();
		}
		int rem=0,ans=0,j=0;
		int[] ANS=new int[size+1];
		for(int i=size-1;i>=0;i--) {
			int c=a[i]+b[i]+rem;
			 if (a[i]==0) {c=b[i];}
		     if (b[i]==0) {c=a[i];}
			 if(c>=10) {
				rem=c/10;
				ans=c-rem*10;
				if(ans<0) {ans*=-1;}
			}else {ans=c;}
			ANS[j]=ans;
			j+=1;
		}for(int i=ANS.length-1;i>=0;i--) {
			System.out.print(ANS[i]);
		}
		
	
	
	}
}
