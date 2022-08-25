package atcoder;

import java.io.*;
import java.util.*;
public class knapsack2_optimal_matrix_by_value {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int N = readInt();
		int W = readInt();
		
		int[] w = new int[N];
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = readInt();
			v[i] = readInt();
		}
		long[][] memo = new long[2][(int) 1e5 + 1];
		
		// if we are taking the minimum, we must fill the array with max value
		for (int i = 0; i < 2; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		
		// at value 0, there is no weight that is needed
		// this line is essential since the algorithm depends on the
		// previous answers
		memo[0][0] = 0;
		int curRow = 1;
		int prevRow = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 1e5 + 1; c++) {
				if (c - v[r] >= 0) {
					// if the value of the current item fits the value index
					memo[curRow][c] = Math.min(memo[prevRow][c], w[r] + memo[prevRow][c - v[r]]);
				}
				else {
					memo[curRow][c] = memo[prevRow][c];
				}
					
			}
			
			
			// XOR operation
			curRow ^= 1;
			prevRow ^= 1;
		}
		
		
		for (int i = (int)1e5; i >= 0; i--) {
			if (memo[prevRow][i] <= W) {
				System.out.println(i);
				return;
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
