package ccc;

import java.io.*;
import java.util.*;
public class CCC06J4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		// dependency arrays track how many prerequisites you must do before the certain task
		// indices represent the task #
		// values inside the array represent the number of prerequisites 
		// depandency array only takes into consideration of 1 layer of prerequisites for
		// a certain task
		int[] dependency = new int[] {1, 0, 0, 2, 1, 0, 1};

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
