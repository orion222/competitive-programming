package atcoder;

import java.io.*;
import java.util.*;
public class DPC_Vacation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		
		int[][] h = new int[n + 1][3];
		
		for (int i = 1; i <= n; i++) {
			h[i][0] = readInt();
			h[i][1] = readInt();
			h[i][2] = readInt();
		}
		
		int[][] memo = new int[n + 1][3];
		
		
		for (int i = 1; i <= n; i++) {
			
			memo[i][0] = Math.max(h[i][0] + memo[i - 1][1], h[i][0] + memo[i - 1][2]);
			memo[i][1] = Math.max(h[i][1] + memo[i - 1][2], h[i][1] + memo[i - 1][0]);
			memo[i][2] = Math.max(h[i][2] + memo[i - 1][0], h[i][2] + memo[i - 1][1]);
			
		}
		
		System.out.println(Math.max(Math.max(memo[n][0], memo[n][1]), memo[n][2]));

		

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
