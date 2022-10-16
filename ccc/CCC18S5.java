package ccc;

import java.io.*;
import java.util.*;
public class CCC18S5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class edge implements Comparable<edge>{
		public int bv;
		public int ev;
		public int cost;
		public char type;
		
		public edge(int bv, int ev, int cost, char type) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
			this.type = type;
		}
		
		public int compareTo(edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(); // planets
		int m = readInt(); // cities
		int p = readInt(); // flights
		int q = readInt(); // portals
		
		edge[] arr = new edge[p + q];
		long ogcost = 0;
		for (int i = 0; i < p; i++) {
			int a = readInt(); int b = readInt(); int c = readInt();
			if (a == b) continue;
			arr[i] = new edge(a, b, c, 'f');  // flight
			ogcost += c * n; // cost * planets
			
		}
		
		for (int i = 0; i < p; i++) {
			int a = readInt(); int b = readInt(); int c = readInt();
			if (a == b) continue;
			arr[i] = new edge(a, b, c, 'p');  // portal
			ogcost += c * m; // cost * cities
			
		}
		
		Arrays.sort(arr);
		Arrays.fill(parents, -1);
		ArrayList<edge> mst = new ArrayList<edge>();
		
		for (edge i: arr) {
			int bvroot = find(i.bv);
			int evroot = find(i.ev);
			
			if (bvroot != evroot) {
				
				
			}
		}
		
		
	}
	
	public static int[] parents;
	public static int find(int v) {
		if (parents[v] == -1) {
			return v;
		}
		
		parents[v] = find(parents[v]);
		return parents[v];
	}
	
	public static void union(int bvroot, int evroot) {
		parents[bvroot] = evroot;
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
