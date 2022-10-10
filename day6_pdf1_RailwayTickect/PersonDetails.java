package day6_pdf1_RailwayTickect;
import java.util.*;
public class PersonDetails {
	Scanner scan=new Scanner(System.in);
	String name;
	int age;
	String gender;
	
	void scan(int k) {
		System.out.print("\nEnter the person("+k+") Name: ");
		name=scan.next().trim();
		System.out.print("\nEnter the person("+k+") Age: ");
		age =scan.nextInt();
		System.out.print("\nEnter the person("+k+") Gender: ");
		gender=scan.next().trim();}
	
	void print(int k) {
		System.out.println("person("+k+") name :"+name);
		System.out.println("person("+k+") Age :"+age);
		System.out.println("person("+k+") Gender :"+gender);
	}
}
