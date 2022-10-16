package SAC;

// https://dmoj.ca/problem/sac21ccp4

import java.io.*;
import java.util.*;
public class SAC21CCP4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		double[] psa = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			psa[i] = psa[i - 1] + readInt();
		}
		
		for (int i = 0; i < q; i++) {
			int l = readInt();
			int r = readInt();
			System.out.println((int)(double)(psa[r] - psa[l - 1]) / (r - l + 1));
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
