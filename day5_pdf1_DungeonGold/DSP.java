package day5_pdf1_DungeonGold;
import java.util.*;
class DSP {
	protected static char[][] ShortestPath(int STi,int STj,int ENDi,int ENDj,char[][] m,char path){
		int rowstart=0,rowend=0;
		int colstart=0,colend=0;
		int rowmove=0,colmove=0;
		
		if(STi>=ENDi&&STj>=ENDj) {			
			rowstart=ENDi+1;rowend=STi+1;
			colstart=ENDj+1;colend=STj;
			rowmove=1;colmove=1;
		}else if(STi<=ENDi&&STj<=ENDj) {
			rowstart=STi;rowend=ENDi;
			colstart=STi+1;colend=ENDj;
			rowmove=1;colmove=1;
		}else if(STi>=ENDi&&STj<=ENDj) {
			rowstart=ENDi+1;rowend=STi+1;
			colstart=STj+1;colend=ENDj+1;
			rowmove=1;colmove=1;
		}else if(STi<=ENDi&&STj>=ENDj) {
			rowstart=STi;rowend=ENDi;
			colstart=ENDj+1;colend=STj;
			rowmove=1;colmove=1;
		}else if(ENDi==STi||ENDj==STj) {
			rowstart=0;rowend=0;
			colstart=0;colend=0;
			rowmove=0;colmove=0;
		}
	
		for(int i=rowstart;i<rowend;i+=rowmove) {
			if(m[i][ENDj]!='M'&&m[i][ENDj]!='A'&&m[i][ENDj]!='T'&&m[i][ENDj]!='P') {
			m[i][ENDj]=path;}
		}
		for(int j=colstart;j<colend;j+=colmove) {
			if(m[STi][j]!='M'&&m[STi][j]!='A'&&m[STi][j]!='T'&&m[STi][j]!='P') {
				m[STi][j]=path;
			}
		}return m;
		
	}

	
	char[][] InsertObj(int i,int j,char[][] m,char Obj) {
		m[i][j]=Obj;
		return m;
	}
	
	
	int CountSteps(char[][] m,char path){
	int steps=0;
	for(int u=0;u<m.length;u++) {
		for(int v=0;v<m[0].length;v++ ) {
			if(m[u][v]==path) {steps+=1;}
		}}
	return steps;}

	
		
	
}