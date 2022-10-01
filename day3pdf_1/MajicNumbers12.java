//to count the no of 1s in the magical infinite series 1 2 2 1 1 2 1 2 2 1 2 2 1 1 2 1 1 2 2......
package day3_pdf1;
import java.util.*;
public class MajicNumbers12 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.print("Enter the limit:");
	int size=scan.nextInt();
	int[] n=new int[size];
	n[0]=1;n[1]=2;n[2]=2;// to start with magical no count
	int count=0,zero=3,start=3;
	for(int i=2;i<size;i++) {//to iterate each element in array n
		for(int j=zero;j<size;j++) {// to iterate from zero for check where the zero starts from
			if(n[j]==0) {//and store the values from zeros
				zero=j;
				break;
			}
		}
			if(n[i]==2&&n[zero-1]==2&&zero+1<size) {
				n[zero]=1;n[zero+1]=1;
			}
			if(n[i]==2&&n[zero-1]==1&&zero+1<size) {
				n[zero]=2;n[zero+1]=2;
			}
			if(n[i]==1&&n[zero-1]==2) {
				n[zero]=1;
			}
			if(n[i]==1&&n[zero-1]==1) {
				n[zero]=2;
			}	
	}System.out.print("The magical seies is: ");
for(int k=0;k<size;k++) {
	if(n[k]==1) {count+=1;}	
	System.out.print(n[k]+" ");
	}System.out.print("\nNo of 1s is ("+count+")");
}			
}
