package ballgame;

public class M3_NumericBalls extends M2_Direction{
	
	

	public static void reduce(int i,int j) {
		String num=area[i][j];
		String change;
		Integer n=Integer.parseInt(num);
		n-=1;
		if(n==0) {change=" ";}
		else{change=n.toString();}
		area[i][j]=change;
	}
	
	public static void main(String[] args) {
		arange();
		brick();
		while (true) {
			System.out.println("Enter Direction");
			String direction=scan.next();
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

