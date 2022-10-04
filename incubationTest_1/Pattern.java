//to print the given pattern
package incubationTest_1;
import java.util.*;
public class Pattern {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
	    System.out.println("enter the limit(4)only");
		int size =scan.nextInt();
	    int colinc=0,rowinc=1;
		for(int i=1;i<=size;i++) {
	    	colinc+=i;
	    	for(int j=rowinc;j<=colinc;j++) {
	    		System.out.print(j);
	    		if(j>1&&j<10&&j<colinc) {System.out.print("*");}
	    	}
	    	System.out.println();rowinc+=i;
	    }
		 int rowdec=size+7,coldec=size+6;
			for(int i=size;i>=1;i--) {
		    	rowdec-=i;
		    	for(int j=rowdec;j<=coldec;j++) {
		    		System.out.print(j);
		    		if(j>1&&j<10&&j<coldec) {System.out.print("*");}
		    	}
		    	System.out.println();coldec-=i;
		    }
	}
}
    