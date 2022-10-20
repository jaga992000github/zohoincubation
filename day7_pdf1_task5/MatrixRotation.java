package day7_pdf1_task5;
import java.util.*;
public class MatrixRotation {
	static Scanner scan =new Scanner(System.in);
	
	static int[][] up(int rs,int re,int cs,int ce,int[][]m) {
		for(int i=rs;i<re;i++) {
			m[i][cs]=m[i+1][cs];
		}
	return m;}
	static int[][] left(int rs,int re,int cs,int ce,int[][]m) {
		for(int j=cs;j<ce;j++) {
			m[re][j]=m[re][j+1];
		}
	return m;}
	static int[][] down(int rs,int re,int cs,int ce,int[][]m) {
		for(int i=re;i>rs;i--) {
			m[i][ce]=m[i-1][ce];
		}
	return m;}
	static int[][] right(int rs,int re,int cs,int ce,int[][]m) {
		for(int j=ce;j>cs;j--) {
			m[rs][j]=m[rs][j-1];
		}
	return m;}
	
	
	static int[][] rotate(int rs,int re,int cs,int ce,int[][]m) {
		int count=m.length/2;
		int n=m.length;
		for(int i=0;i<count;i++){// move to next circle 
			for(int j=1;j<n;j++) {//to move  particlar number of times as per circle size
				int temp=m[rs][cs];
				m=up(rs,re,cs,ce,m);
				m=left(rs,re,cs,ce,m);
				m=down(rs,re,cs,ce,m);
				m=right(rs,re,cs,ce,m);
				m[rs][cs+1]=temp;}
			cs+=1;ce-=1;//to reduce circle
			rs+=1;re-=1;n/=2;//to reduce circle
			}
		return m;
}
public static void main(String[] x) {
	
	System.out.println("Enter the size of square matrix");
	int n=scan.nextInt();
	System.out.println("Enter the matrix values");
	
	int[][] m=new int[n][n];
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
		m[i][j]=scan.nextInt();	
		}
	}
	System.out.println("\n");
	
	int cs=0,ce=m[0].length-1;
	int rs=0,re=m.length-1;
	m=rotate(rs,re,cs,ce,m);
	
	for(int i=0;i<m.length;i++) {
		for(int j=0;j<m[0].length;j++) {
			System.out.print(m[i][j]+" ");
		}System.out.println();
}

}
	
	
	
}
