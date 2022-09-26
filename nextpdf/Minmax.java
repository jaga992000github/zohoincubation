//min max
package nextpdf;
import java.util.*;
public class Minmax {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the size of the array");
		int size = scan.nextInt();
		int[] nums= new int[size];
		System.out.println("please enter the values of the array");
		for(int n=0;n<size;n++) {
			nums[n]=scan.nextInt();}
		int max=0;
		int min=0;
		for(int i=0;i<size;i++) {
			min=nums[i];
			max=nums[i];
			for(int j=0;j<size;j++) {
				if (min>nums[j]) {
					min=nums[j];
				}
				if (max<nums[j]) {
					max=nums[j];
				}
			}
		}System.out.println("max="+max+" min="+min);
	}
	}
