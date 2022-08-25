package ccc;

import java.io.*;
import java.util.*;
public class CCC12S5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		
		boolean[][] invalid = new boolean[r + 1][c + 1];
		int k = readInt();
		for (int i = 0; i < k; i++) {
			invalid[readInt()][readInt()] = true;
		}
		
		int[][] memo = new int[r + 1][c + 1];
		memo[1][1] = 1;
		
		for (int i = 1; i <= r; i++) {
			for (int x = 1; x <= c; x++) {
				if (!invalid[i][x]) {
					memo[i][x] += memo[i - 1][x] + memo[i][x - 1];
				}
			}
		}
		System.out.println(memo[r][c]);
		

	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
