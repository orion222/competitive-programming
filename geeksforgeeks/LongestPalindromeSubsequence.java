package geeksforgeeks;

import java.util.*;

// for longest palindrome subsequence, take the string you are working with,
// save it as s1, and reverse that string and save it as s2
// run normal lcs for those strings
public class LongestPalindromeSubsequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = "";
		for (int i = s1.length() - 1; i >= 0; i--) {
			s2 += s1.charAt(i);
		}
		
		int[][] memo = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int x = 1; x <= s2.length(); x++) {
				if (s1.charAt(i - 1) == s2.charAt(x - 1)) {
					memo[i][x] = memo[i - 1][x - 1] + 1;
				}
				else {
					memo[i][x] = Math.max(memo[i - 1][x], memo[i][x - 1]);
				}
			}
		}
		int lcs = memo[s1.length()][s2.length()];
		
		
		char[] ans = new char[lcs];
		int j = s1.length(); int k = s2.length(); int ind = lcs - 1;
		while (j > 0 && k > 0) {
			if (s1.charAt(j - 1) == s2.charAt(k - 1)) {
				ans[ind] = s1.charAt(j - 1);
				j--; k--; ind--;
			}
			else if (memo[j - 1][k] > memo[j][k - 1]) {
				j--;
			}
			else
				k--;
		}
		
		String answer = "";
		for (char i: ans) answer += i;
		System.out.println("The LPS is " + answer + " of length " + lcs);
		
	}
	
}
