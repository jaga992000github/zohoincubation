package day8_pdf1_OOps;
import java.util.*;
public class Rectangle {
	static int l=0;
	static int b=0;
	static Scanner scan=new Scanner(System.in);
	void display(int l,int  b){
	System.out.println(l+" "+b);	
	}
public static void main(String[] args) {
		
		RectangleArea RA=new RectangleArea();
		RA.read_input();
		Rectangle R=new Rectangle();
		R.display(l, b);
		RA.display(l, b);
	}
}
class RectangleArea extends Rectangle{
	
	static void read_input() {
	l=scan.nextInt();
	b=scan.nextInt();
	}
	void display(int l,int b) {
		System.out.print(l*b);	
	}
	
}
