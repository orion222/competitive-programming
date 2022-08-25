package dmoj;

import java.io.*;
import java.util.*;
public class YACC4P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	// https://dmoj.ca/problem/yac4p1

	public static void main(String[] args) throws IOException {
		int N = readInt();
		
		
		long[] nums = new long[2*N];
		for (int i = 0; i < 2*N; i++) {
			nums[i] = readLong();
		}
		
		int matches = 0;
		for (int x = 0; x < N; x++) {
			if (nums[x] == nums[x + N]) {
				matches++;
			}
		}

		
		System.out.println(matches);
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
