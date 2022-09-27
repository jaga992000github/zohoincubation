// print diamond pattern numbers
package day2pdf_1;
import java.util.*;
public class Diamond {
public static void main(String[] args) {
	int u=1,m=1,a=3;
	for(int i=3;i>=0;i--) {
		for(int j=i;j>0;j--) {
			System.out.print(" ");			
		}for(int k=1;k<=u&&u<=4;k++) {
			System.out.print(m+" ");
			m--;//3,2  6,5,4  10,9,8,7
		}u+=1;// no of numbers row 
			m+=a;
			a+=2;//1,3,6,10(+2,+3,+4)
		System.out.println();
	}
	int v=4,n=10,b=3;
	for(int i=1;i<=4;i++) {
		for(int j=1;j<i;j++) {
			System.out.print(" ");			
			}for(int k=v;k>0;k--) {
				System.out.print(n+" ");
				n--;
			}v-=1;
				System.out.println();
	}
}
	
}
