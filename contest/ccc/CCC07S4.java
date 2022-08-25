package ccc;

// dp approach
import java.io.*;
import java.util.*;
public class CCC07S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static int[] memo;
	public static int n;
	public static ArrayList<Integer>[] graph;
	int count = 0;
	public static void main(String[] args) throws IOException {
		n = readInt();
		memo = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) 
			graph[i] = new ArrayList<Integer>();
		
		int bv = readInt();
		int ev = readInt();
		while (bv != 0 && ev != 0) {
			graph[bv].add(ev);
			bv = readInt();
			ev = readInt();
		}
		memo[1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int x: graph[i]) {
				memo[x] += memo[i];
			}
		}
		
		System.out.println(memo[n]);
		
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
