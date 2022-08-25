package ccc;

import java.io.*;
import java.util.*;
public class CCC00S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int dis = readInt();
		int[] memo = new int[dis + 1];
		Arrays.fill(memo, 5281);
		
		int clubs = readInt();
		int[] w = new int[clubs];
		
		for (int i = 0; i < clubs; i++) {
			w[i] = readInt();
		}
		
		memo[0] = 0;
		for (int c = 1; c < dis + 1; c++) {
			for (int i = 0; i < clubs; i++) {
				if (w[i] <= c) {
					memo[c] = Math.min(memo[c], memo[c - w[i]] + 1); 
				}
			}
		}
		
		if (memo[dis] == 5281) {
			System.out.println("Roberta acknowledges defeat.");
		}
		else
			System.out.println("Roberta wins in " + memo[dis] + " strokes.");
		
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
