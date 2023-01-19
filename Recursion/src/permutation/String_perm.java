package permutation;

public class String_perm {
	static int count=0;
	 
	public static String swap(String a, int i, int j) {
		  char temp;
		  char[] charArray = a.toCharArray();
		  temp = charArray[i];
		  charArray[i] = charArray[j];
		  charArray[j] = temp;
		  return String.valueOf(charArray);
		}
		private static void backtrack(String s, int idx, int N) {
		  if (idx == N) {
		    System.out.println(s);
		    }
		  else {
		    for (int i = idx; i <= N; i++) {
		      s = swap(s, idx, i);
		      backtrack(s, idx + 1, N);
		      s = swap(s, idx, i);
		             
		    }
		  }
		}
	public static void main(String[] args) {
		backtrack("abcdefghijklmnopqrstuvwxyz",0,25);
		System.out.println(count);
	}

}
