package day9_DiwaliQuestions;
import java.util.*;
public class Q4_UnionArray {
	
	static int check(ArrayList<Integer> ans,int num) {
		int presence=0;
		for(int i=0;i<ans.size();i++) {
			if(ans.get(i)==num) {
				presence=1;
				break;
			}
		}return presence;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter array_1 size ");
		int size1=scan.nextInt();
		System.out.println("Enter the numbers");
		int [] n=new int[size1];
		for(int i=0;i<size1;i++) {
			n[i]=scan.nextInt();
		}
		System.out.println("Enter array_2 size ");
		int size2=scan.nextInt();
		System.out.println("Enter the numbers");
		int [] m=new int[size2];
		for(int i=0;i<size2;i++) {
			m[i]=scan.nextInt();
		}
		ArrayList<Integer> ans=new ArrayList<Integer>();
		int presence=0;
		for(int i=0;i<size1;i++) {
			 //presence=check(ans,n[i]);
			if(!ans.contains(n[i])) {
			//if(presence==0) {
			 ans.add(n[i]);}}
		for(int i=0;i<size2;i++) {
			// presence=check(ans,m[i]);
			 if(!ans.contains(m[i])) {
			// if(presence==0) {
			 ans.add(m[i]);}}
		System.out.print(ans);
	}
}
