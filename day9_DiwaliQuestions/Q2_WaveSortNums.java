package day9_DiwaliQuestions;
import java.util.*; 
public class Q2_WaveSortNums {
	
	static int[] sort(int[]nums) {
		int temp=0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				temp=nums[i];
				nums[i]=nums[i+1];
				nums[i+1]=temp;
			}
		}return nums;
	}
	
	static int[] wave_sort(int[]nums) {
		int temp=0;
		for(int i=0;i<nums.length-1;i+=2) {
				temp=nums[i];
				nums[i]=nums[i+1];
				nums[i+1]=temp;
		}return nums;
	}
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no of nums");
		int size=scan.nextInt();
		System.out.println("Enter the nums");
		int [] nums=new int[size];
		for(int i=0;i<size;i++) {
			nums[i]=scan.nextInt();
		}
		
		for(int i=0;i<size;i++) {
			nums=sort(nums);
		}
		nums=wave_sort(nums);
		for(int i=0;i<size;i++) {
			System.out.print(nums[i]+" ");
		}
	}
}
