//to get the sub numbers that sums the target numbers
package incubationTest_1;
import java.util.*;
public class TargetSubArray {
	 public static void main(String args[]) {
	     Scanner scan=new Scanner(System.in);
	     System.out.println("Enter the size of array");
	     int size = scan.nextInt();
	     System.out.println("Enter the target no");
	     int target =scan.nextInt();
	     System.out.println("Enter the values of array");
	     int[] inp=new int[size];
	     for(int i=0;i<size;i++){
	         inp[i]=scan.nextInt();
	     }int n1=0,n2=0;
	     for(int i=0;i<size;i++){
	         for(int j=0;j<size;j++){
	            if(inp[i]+inp[j]==target){
	             n1=inp[i];
	             n2=inp[j];
	            break;
	            }
	         }if(n1!=0&&n2!=0) {
	        	 break;
	         }
	     }System.out.print(n1+" "+n2);
	 }
}
