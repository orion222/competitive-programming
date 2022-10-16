package coci;

// https://dmoj.ca/problem/coci20c4p1
import java.io.*;
import java.util.*;
public class COCI20C4P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		int[] dislikes = new int[101];
		for (int i = 0; i < n; i++) dislikes[readInt()] ++;
		
		int m = readInt();
		int[][] menu = new int[m][101];
		
		for (int i = 0; i < m; i++) {
			int toppings = readInt();
			for (int x = 0; x < toppings; x++) {
				menu[i][readInt()] ++;
			}
		}
		
		int count = m;
		
		for (int i = 0; i < m; i++) {
			for (int x = 0; x < 101; x++) {
				if (menu[i][x] == 1 && dislikes[x] == 1) {
					count --;
					break;
				}
			}
		}
		
		System.out.println(count);

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
