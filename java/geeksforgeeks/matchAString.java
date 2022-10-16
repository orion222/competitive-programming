package geeksforgeeks;

import java.util.Scanner;

// another application of LCS
// given s1 and s1, how many operations do you need
// to have s1 == s2?
// an operation is defined as an insertion or deletion 
// of a character

// many subsequence problems will use LCS
// u just just need the correct formula
public class matchAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// longest common subsequence
		String s1 = sc.next();
		String s2 = sc.next();
		
		// stores the lcs of substrings of the strings
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		// stores the coordinates leading to the current position
		for (int r = 1; r <= s1.length(); r++) {
			for (int c = 1; c <= s2.length(); c++) {
				if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				}
				else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
					
				}
			}
		}
		
		System.out.println((s1.length() + s2.length()) - 2 * dp[s1.length()][s2.length()]); 
	}

}
