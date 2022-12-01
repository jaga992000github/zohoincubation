package ballgame;

public class Demo extends M1_Display {

	public static void left(int i,int j) {
		while(i>=0&&j>=0) {
			if(!area[i][j].equals("W")&&!area[i][j].equals("o")) {
				if(!area[i][j].equals(" ")) {
				M3_NumericBalls.reduce(i,j);
					area[i][j]=" ";
					ballpos[0]=i;
					ballpos[1]=j;
					fall();
				break;
					}
				}
				
			else if(area[i][j].equals("W")) {
				for(int k=j;k<7;k++) {
					if(!area[i][k].equals(" ")&&!area[i][k].equals("W")) {
						M3_NumericBalls.reduce(i,k);
						ballpos[0]=i;
						ballpos[1]=k;
						fall();
						break;
						}
				}
			}
			i-=1;j-=1;}
		}
	
	public static void right(int i,int j) {
		while(i>=0&&j<7) {
			if(!area[i][j].equals("W")&&!area[i][j].equals("o")) {
				if(!area[i][j].equals(" ")) {
				M3_NumericBalls.reduce(i,j);
					ballpos[0]=i;
					ballpos[1]=j;
					fall();
					break;
					}
				}
				
			else if(area[i][j].equals("W")) {
				for(int k=6;k>=0;k--) {
					if(!area[i][k].equals(" ")&&!area[i][k].equals("W")) {
						M3_NumericBalls.reduce(i,k);
						ballpos[0]=i;
						ballpos[1]=k;
						fall();
						break;
						}
				}
			}
			i-=1;j+=1;}
		}
	
	public static void straight(int i,int j) {
		for(int k=i;k>=0;k--) {
			if(!area[k][j].equals("W")&&!area[i][j].equals("o")) {
				if(!area[k][j].equals(" ")) {
				M3_NumericBalls.reduce(k,j);
					ballpos[0]=k;
					ballpos[1]=j;
					fall();
					break;
				}
			}
		}
	}
	
	public static void fall() {
		ballpos[0]=6;
		if(!area[ballpos[0]][ballpos[1]].equals("o")) {
			ballcount-=1;
			ballpos[0]=6;
			ballpos[1]=3;
		}
	}
	
	public static void direct(String direction) {
		if(direction.equals("st")) {
			straight(ballpos[0],ballpos[1]);
		}
		if(direction.equals("ld")) {
			left(ballpos[0],ballpos[1]);
		}
		if(direction.equals("rd")) {
			right(ballpos[0],ballpos[1]);
		}
	}
	
	public static void main(String[] args) {
		arange();
		brick();
		while (true) {
			//System.out.println("Enter Direction");
			String direction="st";//scan.next();
			direct(direction);
			display();
			System.out.println(ballpos[0]+" "+ballpos[1]);
			System.out.println("continue 1\n"
					+ "break 0");
			int n=scan.nextInt();
			if(n==0) {
				break;
			}
		}
	}

}
