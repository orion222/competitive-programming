package atcoder;

import java.io.*;
import java.util.*;
public class knapsack2_optimal_matrix_by_weight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int N = readInt();
		int W = readInt();
		
		long[] weights = new long[N + 1];
		int[] vals = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			weights[i] = readInt();
			vals[i] = readInt();
			
		}
		
		long[][] memo = new long[2][(int)1e3 + 1];
		
		int prev = 0;
		int cur = 1;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c < 1e3 + 1; c++) {
				
				if (vals[r] <= c) {
					memo[cur][c] = Math.max(memo[prev][c], weights[r] + memo[prev][(int) (c - vals[r])]);
				}
				else {
					memo[cur][c] = memo[prev][c];
				}
			}
			prev = prev^1;  // ^ means XOR. 0 XOR 1 = 1
			cur = cur^1;    // 1 XOR 1 = 0
			
			// ALTERNATE BETWEEN OLD AND NEW RESULTS FOR DP
		}
		
		int temp = 0;

		for (int i = 0; i < 1e3; i++) {
			if (memo[prev][i] > W) break;
			temp = i;
		}
		
		System.out.println(temp);
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
