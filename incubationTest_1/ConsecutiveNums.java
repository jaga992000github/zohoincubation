// to check the given array is consecutive numbers
package incubationTest_1;
import java.util.*;

public class ConsecutiveNums {
	public static void main(String args[]) {
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter the size of consecutive numbers");
    int size = scan.nextInt();
    int repeat=0,ans=1;
    System.out.println("Enter the consecutive numbers");
    int[] inp=new int[size];
    for(int i=0;i<size;i++){
        inp[i]=scan.nextInt();
    }int min=0,max=0;
    for(int i=0;i<size;i++){
        min=inp[i];max=inp[i];
        for(int j=0;j<size;j++){
           if(inp[i]==inp[j]&&i!=j) {repeat=inp[i];ans=0;break;}
           if(min>inp[j]){min=inp[j];}
           if(max<inp[j]){max=inp[j];}
        }if(repeat!=0) {break;}
    }if(ans==1) {
    	 System.out.print("The array contains consecutive integers from "+min+" to "+max);
    }else {
    System.out.print("The array does not contains consecutive integers as element "+repeat+" is repeated");}
   }
}
