package incubation;
import java.util.*;
public class Binaryadd {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the size of 1stbinary no:");
		int size1 = scan.nextInt();
		System.out.println("please enter the size of 2binary no:");
		int size2 = scan.nextInt();
		int[] binA= new int[size1];
		int[] binB= new int[size2];
		int u=2*size1;
		int v=2*size2;
		int a =0;
		int b =0;
		System.out.println("enter the binary no1:");
		for(int i=0;i<size1;i++) {
			binA[i]=scan.nextInt();
			if(binA[i]==1) {a+=u;}
			u/=2;}
		System.out.println(" "+a);
		System.out.println("enter the binary no2:");
		for(int j=0;j<size2;j++) {
			binB[j]=scan.nextInt();
			if(binB[j]==1) {b+=v;}
			v/=2;}
		System.out.println(" "+b);
		
		int c=a+b;
		int val =0;//high bin number in it
		for(int n=1;n<=c;n*=2) {
			val=n;
		}System.out.println("the adition value of the binary numbers is:");
		int ans=0;
		while(val>=1) {
			if(ans==c) {break;}
			if((ans+val)<c) {
				ans+=val;
				System.out.print(1);}
			else {
				val/=2;
				System.out.print(0);}
				}System.out.println(" "+c);
	}
}
