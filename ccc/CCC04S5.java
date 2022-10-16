package ccc;

import java.io.*;
import java.util.*;
public class CCC04S5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		while (true) {
			int m = readInt();
			int n = readInt();
			if (m == 0 && n == 0) break;
			
			char[][] graph = new char[m][n];
			for (int i = 0; i < m; i++) {
				graph[i] = next().toCharArray();
			}
			int[][] memo = new int[m + 1][n + 1];
			
			for (int c = 1; c <= n; c++) {
				for (int r = m; r >= 1; r--) {
					
				}
			}
			
		}
		
		

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
