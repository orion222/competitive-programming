package algos;

import java.io.*;
import java.util.*;
public class fibonacci {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	private static int fib(int n, int[] memo) {
		if (n == 0)
			return 0;
		
		else if (n == 1)
			return 1;
		
		else if (memo[n] == 0) 
			memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
	
		return memo[n];
	}
	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		
		int[] memo = new int[(int)1e3];
		System.out.println(fib(n, memo));
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
