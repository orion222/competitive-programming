package ananimalcontest;

import java.io.*;
import java.util.*;

public class Contest1_P3_Happy_Alpacas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {
		int n = readInt(); int x = readInt();
		
		if (n - x == 1)
			System.out.println(-1);
		
		else if (n == x) {
			for (int i = 0; i < n; i++)
				System.out.print(1 + ((i == n - 1) ? "": " "));
		}
		else {
			int[] arr = new int[n];
			String result = "";
			
			
			for (int i = 0; i < x + 1; i++) {
				arr[i] = 1;
			}
			
			for (int i = x + 1; i < n; i++)
				arr[i] = 0;
			
			for (int i: arr) {
				result += i + " ";
			}
			System.out.println(result.substring(0, result.length() - 1));

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


