package algos;

/*
 * Print all the subsets of a string
 * Subsets = combination
 * 
 * 
 */
public class bitwiseExercise {
	
	public static void main(String[] args) {
		String a = "abc";
		
		int N = a.length();
		
		String[] ans = new String[(int) Math.pow(2, a.length())];
		
		/*
		 * i is a counter that displays all numbers 0-7 in binary
		 * 000  (remember that an empty string is a subset)
		 * 001
		 * 010
		 * 011
		 * 100
		 * 101
		 * 110
		 * 111
		 * 
		 * the nested for-loop loops through the bits of each
		 * permutation, checking if that a bit at position i
		 * is equal to 1. if so, map that index to the letter
		 * of the original string
		 */
		for (int i = 0; i <= Math.pow(2, N) - 1; i++){
			
			String subset = "";
			for (int x = 0; x < N; x++) {
				if (((i >> x) & 1) == 1) {
					subset += a.charAt(x);
				}
			}
			
			ans[i] = subset;
		}
		
		for (String i: ans) {
			System.out.println(i);
		}
	}
}
