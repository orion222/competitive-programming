package random;

// https://dmoj.ca/problem/wac1p1
import java.io.*;

import java.util.*;
public class WAC1P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
			
		int t = readInt();
		for (int i = 0; i < t; i++) {
			long m = readLong();
			
			// there is a lot of math behind this problem
			// sequence of 2, 3, 3, 4, 4, 4, 5, 5, 5, 5 ... 
			// nth term is minimum nodes given n edges
			// let x = last position of n in the sequence
			// e.g x for 4 would be 6
			
			// using arithmetic series..
			// [(n - 1)/2](1 + n - 1) = x
			// n^2 - n - 2x = 0
			
			double sum = Math.ceil(1.00 / 2.00 + Math.sqrt(1.00 / 4.00 + 2 * m));
			System.out.println((int)sum);
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
