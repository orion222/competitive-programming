package ccc;

import java.io.*;
import java.util.*;
public class CCC17S1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] swifts = new int[n];
		int[] sema = new int[n];
		
		for (int i = 0; i < n; i++) {
			swifts[i] = readInt();
		}
		
		for (int i = 0; i < n; i++) {
			sema[i] = readInt();
		}
		
		int sum1 = 0;
		int sum2 = 0;
		int maxCount = 0;
		for (int i = 0; i < n; i++) {
			sum1 += swifts[i];
			sum2 += sema[i];
			if (sum1 == sum2) {
				maxCount = i + 1;
			}
		}
		
		System.out.println(maxCount);

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
