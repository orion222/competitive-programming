package atcoder;

// https://dmoj.ca/problem/dph
import java.io.*;
import java.util.*;
public class DPH_Grid1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int h = readInt();
		int w = readInt();
		char[][] graph = new char[h + 1][w + 1];
		for (int i = 1; i <= h; i++) {
			graph[i] = next().toCharArray();
		}

		
		long[][] memo = new long[h + 1][w + 1];
		memo[1][1] = 1;
		for (int r = 1; r <= h; r++) {
			for (int c = 1; c <= w; c++) {
				if (graph[r][c - 1] != '#') {
					memo[r][c] += (long)(memo[r - 1][c] + memo[r][c - 1]  % (1e9 + 7));
				}
			}
		}
		
		System.out.println(memo[h][w]);

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
