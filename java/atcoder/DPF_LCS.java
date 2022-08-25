package atcoder;

import java.util.*;
// https://dmoj.ca/problem/dpf
public class DPF_LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// longest common subsequence
		String s1 = sc.next();
		String s2 = sc.next();
		
		// stores the lcs of substrings of the strings
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		// stores the coordinates leading to the current position
		Node[][] memo = new Node[s1.length() + 1][s2.length() + 1];
		for (int r = 1; r <= s1.length(); r++) {
			for (int c = 1; c <= s2.length(); c++) {
				if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
					memo[r][c] = new Node(r - 1, c - 1);
				}
				else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
					
					// if it is bigger, then it must've came from that square
					if (dp[r - 1][c] > dp[r][c - 1]) 
						memo[r][c] = new Node(r - 1, c);
					else
						memo[r][c] = new Node(r, c - 1);
				}
			}
		}
		
		

		// the string of the LCS
		String lcs = "";
		
		// if the length of the lcs is greater than 0, then we look for the string
		if (dp[s1.length()][s2.length()] > 0) {
			Node cur = new Node(s1.length(), s2.length());
			while (true) {
				Node from = memo[cur.r][cur.c];
				if (cur.r - 1 == from.r && cur.c - 1 == from.c) {
					lcs += s1.charAt(cur.r - 1);
					if (dp[from.r][from.c] == 0) {
						break;
					}
				}
				cur = from;
			}
		}
		if (lcs.equals("")) 
			System.out.println("");
		else {
			for (int i = lcs.length() - 1; i >= 0; i--) {
				System.out.print(lcs.charAt(i));
			}
		}

	}
	
	public static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

}
