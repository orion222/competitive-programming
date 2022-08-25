package random;

// https://dmoj.ca/problem/wac1p2
// i hate this question

import java.io.*;
import java.util.*;
public class wac1p2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Edge {
		
		public int bv;
		public int ev;
		
		public Edge(int bv, int ev) {
			this.bv = bv;
			this.ev = ev;
		}
		
		public String toString() {
			return this.bv + " " + this.ev;
		}
	}
	
	public static int[] parents;
	public static int find(int v) {
		if (parents[v] == -1)
			return v;
		parents[v] = find(parents[v]);
		return parents[v];
	}
	
	public static void union(int bvroot, int evroot) {
		parents[bvroot] = evroot;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		int v = readInt(); int e = readInt(); int k = readInt();
		
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		parents = new int[v + 1];
		Arrays.fill(parents, -1);
		for (int i = 0; i < e; i++) {
			int bv = readInt();
			int ev = readInt();
			int bvroot = find(bv);
			int evroot = find(ev);
			
			if (bvroot != evroot) {
				union(bvroot, evroot);
				mst.add(new Edge(bv, ev));
				
			}
		}
		
		
		if (mst.size() == v - 1) 
			System.out.println(0);
		

		
		else {  
			int extra = e - mst.size();
			int needed = (v - 1) - mst.size();
			int mustBeBuilt = Math.max(0, needed - extra);

			if (extra - k <= 0) // if there are enough volunteers
				System.out.println(mustBeBuilt);
			
			else { // there are not enough volunteers
				System.out.println(Math.max(0, needed - k));
			}
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
