package atcoder;

import java.io.*;
import java.util.*;
public class DPB_Frog2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		
		int[] memo = new int[n + 1];
		int[] h = new int[n + 1];
		for (int i = 1; i <= n; i++) h[i] = readInt();
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i - j >= 1) {
					memo[i] = Math.min(memo[i], memo[i - j] + Math.abs(h[i] - h[i - j]));
				}
			}
						
		}
		
		System.out.println(memo[n]);
		
		
		

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
