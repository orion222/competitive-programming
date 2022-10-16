package dmopc;

import java.io.*;
import java.util.*;
public class dmopc16c4p5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static boolean[] mstSet;
	public static int[] parents;
	public static int[] maxCost;
	public static int n;

	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		
		ArrayList<Node>[] adj = new ArrayList[m + 1];
		for (int i = 1; i < m + 1; i++) adj[i] = new ArrayList<Node>();
		
		for (int i = 1; i < m + 1; i++) {
			int bv = readInt();
			int ev = readInt();
			int cost = readInt();
			
			adj[bv].add(new Node(ev, cost));
			adj[ev].add(new Node(bv, cost));
			
		}
		
		mstSet = new boolean[n + 1];
		parents = new int[n + 1];
		maxCost = new int[n + 1];
		Arrays.fill(maxCost, Integer.MIN_VALUE);
		
		
		
		
	}
	
	public static int findNext() {
		
		int max = Integer.MIN_VALUE;
		int index = -1;
		
		for (int i = 1; i <= n ; i++) {
			if (maxCost[i] > max) {
				index = i;
				max = maxCost[i];
			}
		}
		return index;
		
	}
	
	
	
	public static class Node implements Comparable<Node>{
		public int ev;
		public int cost;
		
		public Node(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return o.cost - this.cost;
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
