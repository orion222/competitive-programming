package dmopc;

import java.io.*;
import java.util.*;
public class dmopc15c6p4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static class Edge implements Comparable<Edge>{
		public int bv;
		public int ev;
		public int cost;
		
		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(cost, o.cost);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		int v = readInt(); int k = readInt();
		
		
		ArrayList<Edge> arr = new ArrayList<Edge>();
		
		for (int i = 0; i < v - 1; i++) {
			arr.add(new Edge(i + 1, i + 2, readInt()));
			if (i + k < v) {
				arr.add(new Edge(i + 1, i + k + 1, 0));
			}
		}
		
		Collections.sort(arr);
		
		parents = new int[v + 1];
		Arrays.fill(parents, -1);
		
		int sum = 0;
		ArrayList<Edge> mst = new ArrayList<Edge>();
		for (Edge e: arr) {
			int bvroot = find(e.bv);
			int evroot = find(e.ev);
			
			if (bvroot != evroot) {
				sum += e.cost;
				union(bvroot, evroot);
				if (mst.size() == v - 1)
					break;
			}
		}
		
		System.out.println(sum);
	}
	
	
	
	// 1 index parents
	
	public static int[] parents;
	public static int find(int v) {
		
		if (parents[v] == -1)
			return v;
		
		parents[v] = find(parents[v]);
		return parents[v];
		
	}
	
	public static void union(int bv, int ev) {
		parents[bv] = ev;
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
