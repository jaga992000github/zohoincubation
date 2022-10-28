package day5_pdf1_DungeonGold;
import java.util.*;
public class DFS {
	static ArrayList<String>stack=new ArrayList();	
	static int Si=7,Sj=0,Ei=0,Ej=7,found=0;
	static char[][] m= {
			{'P','_','P','_','_','_','P','_'},
			{'_','_','P','_','_','P','_','_'},
			{'_','P','p','_','P','P','_','P'},
			{'_','P','P','_','_','P','_','P'},
			{'_','P','P','P','_','P','_','P'},
			{'_','_','P','P','_','P','_','_'},
			{'P','_','_','_','_','_','p','_'},
			{'_','_','P','P','P','_','_','_'}
	};
	
	
	static void memory(int i,int j) {
		String path=i+" "+j;
		stack.add(path.trim());
	}
	
	static int LastValue(int n) {
		String last=stack.get((stack.size())-1);
		String row="";
		String col="";
		int space=0;
		int value=0;
		if(n==1) {
			/*for(int i=0;i<last.length();i++) {
				if(last.charAt(i)==' ') {
					space=i;
					break;*/
				row+=(last.charAt(0)+"");	
			value=Integer.parseInt(row.trim());}
		
		else if(n==2) {
			//for(int i=space+1;i<last.length();i++) {
				col+=(last.charAt(last.length()-1)+"");	
			value=Integer.parseInt(col.trim());
		}return value;
	}
	
	
	static void lastpop() {
		int lastIndex=(stack.size())-1;
		stack.remove(lastIndex);
	}
	
	static int up(int Si,int Sj,int Ei,int Ej,char path,int found){
		char end=m[Ei][Ej];
		if(Si-1>=0) {
			if(m[Si-1][Sj]=='_'||m[Si-1][Sj]==end) { //up
				if(m[Si-1][Sj]==end){return found=1;}
				else if(found==0) {Si-=1;m[Si][Sj]=path;
				memory(Si,Sj);
				up(Si,Sj,Ei,Ej,path,found);}
		}else {return right(Si,Sj,Ei,Ej,path,found);}
		}else {return right(Si,Sj,Ei,Ej,path,found);}
		return found;
	}
	static int right(int Si,int Sj,int Ei,int Ej,char path,int found){
		char end=m[Ei][Ej];
		if(Sj+1<m[Si].length) {
			if(m[Si][Sj+1]=='_'||m[Si][Sj+1]==end) {//right
				if(m[Si][Sj+1]==end){return found=1;}
				else if(found==0) {Sj+=1;m[Si][Sj]=path;
				memory(Si,Sj);
				up(Si,Sj,Ei,Ej,path,found);}
		}else {return down(Si,Sj,Ei,Ej,path,found);}
		}else {return down(Si,Sj,Ei,Ej,path,found);}
		return found;
	}
		
	static int down(int Si,int Sj,int Ei,int Ej,char path,int found){
		char end=m[Ei][Ej];
		if(Si+1<m.length) {
			if(m[Si+1][Sj]=='_'||m[Si+1][Sj]==end) {//down
				if(m[Si+1][Sj]==end){return found=1;}
				else  if(found==0){Si+=1;m[Si][Sj]=path;
				memory(Si,Sj);
				up(Si,Sj,Ei,Ej,path,found);}
			}else {return  left(Si,Sj,Ei,Ej,path,found);}
			}else {return  left(Si,Sj,Ei,Ej,path,found);}
		return found;
	}
			
	static int left(int Si,int Sj,int Ei,int Ej,char path,int found){
		char end=m[Ei][Ej];
		if(Sj-1>=0) {
			if(m[Si][Sj-1]=='_'||m[Si][Sj-1]==end) {//left
				if(m[Si][Sj-1]==end){return found=1;}
				else if(found==0){Sj-=1;m[Si][Sj]=path;
				memory(Si,Sj);
				up(Si,Sj,Ei,Ej,path,found);}
			}else {lastpop();m[Si][Sj]='#';
			Si=LastValue(1);
			Sj=LastValue(2);
			return  up(Si,Sj,Ei,Ej,path,found);}
			}else {lastpop();m[Si][Sj]='#';
			Si=LastValue(1);
			Sj=LastValue(2);
			return  up(Si,Sj,Ei,Ej,path,found);}
		return found;
		}	
	
	public static void main(String[]args) {
		m[Si][Sj]='A';
		m[Ei][Ej]='G';
		found=up(Si,Sj,Ei,Ej,'*',found);
		
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(m[i][j]+" ");
			}System.out.println();//
		}
		System.out.println(stack);
	}
}
