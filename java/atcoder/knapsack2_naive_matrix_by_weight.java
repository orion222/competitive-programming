package atcoder;

import java.io.*;
import java.util.*;
public class knapsack2_naive_matrix_by_weight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int W = readInt();
		
		long[] weights = new long[N + 1];
		long[] vals = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = readInt();
			vals[i] = readInt();
			
		}
		
		long[][] memo = new long[N + 1][W + 1];
		
		
		// item # pointer
		for (int r = 1; r <= N; r++) {
			
			// weight pointer
			for (int c = 1; c <= W; c++) {
				if (weights[r] <= c) {
					// add the weight of the new item to the previously most optimal answer
					memo[r][c] =  Math.max(memo[r - 1][c], vals[r] + memo[r - 1][(int) (c - weights[r])]);
				}
				else {
					// copy from the one before if the new item cannot fit 
					memo[r][c] = memo[r - 1][c];
				}
			}
		}
		
		System.out.println(memo[N][W]);
		
		
		
		

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
