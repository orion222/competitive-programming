package atcoder;

import java.io.*;
import java.util.*;
public class DPG_LongestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static ArrayList<Integer>[] adj;
	public static int[] memo;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		
		
		adj = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			adj[readInt()].add(readInt());
		}
		memo = new int[n + 1];
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, path(i));
		}
		System.out.println(max);
		
		
	}
	
	// finds the longest directed path starting from v
	public static int path(int v) {
		if (adj[v].size() == 0) {
			return 0;
		}
		if (memo[v] != 0)
			return memo[v];
		
		// the longest directed path of v is also
		// equal to the longest directed path of its neighbor + 1
		// since they are adjacent
		for (int neighbor: adj[v]) {
			memo[v] = Math.max(memo[v], path(neighbor) + 1);
		}
		return memo[v];
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
