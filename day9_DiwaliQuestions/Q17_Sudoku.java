package day9_DiwaliQuestions;
import java.util.*;
public class Q17_Sudoku {
	
	static HashSet <Integer> Miss=new HashSet<Integer>();
	static HashSet <Integer> Contain=new HashSet<Integer>();
	
	static HashSet<Integer> TakeRowCol(int row,int col) {
		for(int i=0;i<9;i++) {
			if(m[i][col]!=0) {
			Contain.add(m[i][col]);}}
		for(int j=0;j<9;j++) {
			if(m[row][j]!=0) {
			Contain.add(m[row][j]);}}
		return Contain;
	}
	
	static  HashSet<Integer> TakeSubMat(int row,int col) {
	int rs=0,re=0,cs=0,ce=0;
		if((row+1)%3==0) {re=row+0;rs=row-2;}
		else if((row+2)%3==0) {re=row+1;rs=row-1;}
		else if((row+3)%3==0) {re=row+2;rs=row-0;}
		
		if((col+1)%3==0) {ce=col+0;cs=col-2;}
		else if((col+2)%3==0) {ce=col+1;cs=col-1;}
		else if((col+3)%3==0) {ce=col+2;cs=col-0;}
		
		for(int i=rs;i<=re;i++) {
			for(int j=cs;j<=ce;j++) {
				if(m[i][j]!=0) {
				Contain.add(m[i][j]);}}
			}return Contain;
	}
	static HashSet<Integer> Find(int row,int col){
		Contain=TakeRowCol(row,col);
		Contain=TakeSubMat(row,col);
		return  Contain;
	}
	
	static void solve() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(m[i][j]==0) {
					Contain.clear();;
					Contain=Find(i,j);
					Miss.clear();
					for(int i1=1;i1<=9;i1++) {
						if(!Contain.contains(i1)) {
							Miss.add(i1);}
						}if(Miss.size()==1)
							{
							String miss =Miss.toString() ;
							m[i][j]=Integer.parseInt(miss.charAt(1)+"");
							}
						}
				}
			}		}

	static int check(int[][]m) {
		int present=1;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(m[i][j]==0) {
					present=0;
					break;
				}
			}
		}return present;
	}
	
	
	//static int m[][]=new int[9][9];
	static int m[][]= {
			{5,3,0,0,7,0,0,0,0},
			{6,0,0,1,9,5,0,0,0},
			{0,9,8,0,0,0,0,6,0},
			{8,0,0,0,6,0,0,0,3},
			{4,0,0,8,0,3,0,0,1},
			{7,0,0,0,2,0,0,0,6},
			{0,6,0,0,0,0,2,8,0},
			{0,0,0,4,1,9,0,0,5},
			{0,0,0,0,8,0,0,7,9}
	};
	
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		
		/*for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				m[i][j]=scan.nextInt();
			}
		}*/
		
		int check=check(m);
		while(check!=1) {
		solve();//replace o with ans
		check=check(m);
		}
		
		
		System.out.println("\n____________________________\n");
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(m[i][j]+" ");
				if((j+1)%3==0) {
					System.out.print(" |  ");}
			}if((i+1)%3==0)
			{System.out.println("\n____________________________\n");}
			else {System.out.println();}
		}
	}
}
