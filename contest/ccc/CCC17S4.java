package ccc;

import java.io.*;
import java.util.*;


public class CCC17S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Edge implements Comparable<Edge>{
		public int bv;
		public int ev;
		public int cost;
		public int active;
		
		public Edge(int bv, int ev, int cost, int active){
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
			this.active = active;
		}
		
		public int compareTo(Edge o) {
			
			int z = Integer.compare(this.cost, o.cost);
			if (z == 0)
				return Integer.compare(this.active,  o.active);  // sort by active FIRST if same cost
			return z;
		}
		
		public String toString() {
			return this.bv + " " + this.ev + " " + this.cost + " " + this.active;
		}
		
	}
	
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
	

	public static void main(String[] args) throws IOException {
		
		int n = readInt(); int m = readInt(); int d = readInt();
		
		Edge[] arr = new Edge[m];
		
		// 0 means active, 1 means not active
		for (int i = 0; i < n - 1; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			arr[i] = new Edge(a, b, c, 0);
		}
		
		
		for (int i = n - 1; i < m; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			arr[i] = new Edge(a, b, c, 1);
		}
		
		Arrays.sort(arr);
		
		
		parents = new int[n + 1];
		Arrays.fill(parents, -1);
		
		Edge lastEdge = null;

		ArrayList<Edge> mst = new ArrayList<Edge>();
		int days = 0;
		for (int i = 0; i < arr.length; i++) {
			Edge e = arr[i];
			int bvroot = find(e.bv);
			int evroot = find(e.ev);
			
			if (evroot != bvroot) {
				
				mst.add(e);
				days += e.active;
				union(bvroot, evroot);

				if (mst.size() == n - 1) {

					lastEdge = e;
					break;
				}
				
				
			}
		}
		
		if (lastEdge.active == 1 && d > 0) {
			
			Arrays.fill(parents, -1);
			for (int i = 0; i < arr.length; i++) {
				Edge cur = arr[i];
				
				int bvroot = find(cur.bv);
				int evroot = find(cur.ev);
				
				if (bvroot != evroot) {
					if (cur.cost < lastEdge.cost || cur.cost == lastEdge.cost && cur.active == 0)
						union(bvroot, evroot);
					else if (cur.cost > lastEdge.cost && cur.cost <= d && cur.active == 0) {
						days--;
						break;
					}
				}
			}
		}

		
		System.out.println(days);


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