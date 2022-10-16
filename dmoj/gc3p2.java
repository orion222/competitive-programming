package dmoj;

import java.io.*;
import java.util.*;
public class gc3p2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int e = readInt();
		
		ArrayList<Node>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<Node>();
		for (int i = 0; i < e; i++) {
			int a = readInt(); int b = readInt(); int c = readInt();
			
		}
		
	}
	
	public class Node{
		public int ev;
		public int cost;
		
		public Node(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
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
