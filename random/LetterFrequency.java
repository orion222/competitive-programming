package random;

// https://dmoj.ca/problem/bts18p2

import java.io.*;
import java.util.*;
public class LetterFrequency {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String s = readLine(); int q = readInt();
		int[][] psa = new int[26][s.length() + 1];
		char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < 26; i++) {
			for (int x = 1; x < s.length() + 1; x++) {
				if (s.charAt(x - 1) == alpha[i]) {
					psa[i][x] = psa[i][x - 1] + 1;
				}
				else {
					psa[i][x] = psa[i][x - 1];
				}
			}
		}
		
		for (int i = 0; i < q; i++) {
			int a = readInt(); int b = readInt(); char letter = readCharacter();
			int letterVal = (int)letter - 97;
			System.out.println(psa[letterVal][b] - psa[letterVal][a - 1]);
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
