package incubationTest_1;
//you have to get max no on how many patients has get treating in singe day
import java.util.*;
public class MaxPatient {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the no of days");
	int size =scan.nextInt();
	System.out.println("enter the day count to be treated");
	int Td=scan.nextInt();
	System.out.println("enter the patients count");
	int n[]=new int[size];
	for(int i=0;i<size;i++) {
		n[i]=scan.nextInt();
	}
	int day=1,treated=0,end=0,max=0;
	while(day<=size+(Td)) {
		if(day>Td) {
			n[day-(Td+1)]=0;
			}
		
		treated=0;
		end=day;
		if(end>size) {end=size;}
		for(int j=0;j<end;j++) {
			treated+=n[j];
			if(max<=treated) {max=treated;}
			}
			for(int i=0;i<size;i++) {
				System.out.print(n[i]+" ");
			}System.out.println("("+treated+")"+ (day));
			day+=1;
	}System.out.println("Maximum patients treated on single day: "+max);
}
}
