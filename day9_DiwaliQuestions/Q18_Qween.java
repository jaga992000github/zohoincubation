package day9_DiwaliQuestions;
import java.util.*;
public class Q18_Qween {
	static Scanner scan=new Scanner(System.in) ;
	static int found=0;

	static int UpAndDown(int Qi,int Qj,char[][]board) {
		int j=Qj;
		for(int i=0;i<board.length;i++) {
			if(board[i][Qj]!='Q') {board[i][Qj]='*';}
			if(board[i][Qj]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}
		}return found;
	}
	static int LeftAndRight(int Qi,int Qj,char[][]board) {
		int i=Qi;
		for(int j=0;j<board[Qi].length;j++) {
			if(board[i][Qj]!='Q') {board[i][Qj]='*';}
			if(board[Qi][j]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}
		}return found;
	}
	static int LeftCross(int Qi,int Qj,char[][]board) {
		int i=Qi,j=Qj;
		while(Qi<board.length&&Qj<board[Qi].length) {
			if(board[i][Qj]!='Q') {board[Qi][Qj]='*';}
			if(board[Qi][Qj]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}Qi+=1;Qj+=1;
		}Qi=i;Qj=j;
		while(Qi>=0&&Qj>=0) {
			if(board[i][Qj]!='Q') {board[Qi][Qj]='*';}
			if(board[Qi][Qj]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}Qi-=1;Qj-=1;
		}return found;
	}
	static int RightCross(int Qi,int Qj,char[][]board) {
		int i=Qi,j=Qj;
		while(Qi>=0&&Qj<board[Qi].length) {
			if(board[i][Qj]!='Q') {board[Qi][Qj]='*';}
			if(board[Qi][Qj]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}Qi-=1;Qj+=1;
		}Qi=i;Qj=j;
		while(Qi<board.length&&Qj>=0) {
			if(board[i][Qj]!='Q') {board[Qi][Qj]='*';}
			if(board[Qi][Qj]=='Q'&&Qi!=i&&Qj!=j) {
				found=1;break;
			}Qi+=1;Qj-=1;
		}return found;
	}
	
	
	static int check(int Qi,int Qj,char[][]board) {
		UpAndDown(Qi,Qj,board);
		LeftAndRight(Qi,Qj,board);
		LeftCross(Qi,Qj,board);
		RightCross(Qi,Qj,board);
		return 0;
	}
	
	static void refresh(char[][]board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]='-';
			}
		}
	}
	
	static void Print(char[][]board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" ");
			}System.out.println();
		}
	}
	
	
	public static void main(String[]args) {
		System.out.println("Enter board size");
		int size =scan.nextInt();
		char[][] board=new char[size][size];
		refresh(board);
		
		for(int k=1;k<=size-2;k++) {
			refresh(board);
			board[0][k]='Q';
			check(0,k,board);
			for(int i=1;i<board.length;i++) {
				int j=0;
				while (j<board[i].length){
					if(board[i][j]=='-') {
						board[i][j]='Q';
					check(i,j,board);break;
					}else {j+=1;}
			}
		}
		
		Print(board);
		System.out.print("\n\n");}
	}
}
