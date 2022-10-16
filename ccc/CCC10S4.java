package ccc;

import java.io.*;
import java.util.*;

public class CCC10S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class edge implements Comparable<edge>{
		
		public int bv;
		public int ev;
		public int cost;
		
		public edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		
		public int compareTo(edge f) {
			return Integer.compare(this.cost, f.cost);
		}
		
		public String toString(edge e) {
			return e.bv + " " + e.ev + " " + e.cost;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// init
		int z = readInt();
		
		HashMap<String, ArrayList<int[]>> map = new HashMap<String, ArrayList<int[]>>();
		
		//
		
		for (int i = 0; i < z; i++) {
			int n = readInt();
			
			int[] vertices = new int[n];
			int[] prices = new int[n];
			for (int x = 0; x < n; x++) {
				vertices[x]= readInt();
			}
			
			for (int x = 0; x < n; x++) {
				prices[x]= readInt();
			}
			
			for (int x = 0; x < n; x++) {
				int a = vertices[x]; int b = vertices[(x + 1) % n]; int c = prices[x];
				String curKey = Math.min(a, b) + " " + Math.max(a, b);
				map.putIfAbsent(curKey, new ArrayList<int[]>());
				map.get(curKey).add(new int[] {i, c});
			}			
		}
		
		ArrayList<edge> arr = new ArrayList<edge>();
		for (ArrayList<int[]> i: map.values()) {
			if (i.size() > 1) {
				arr.add(new edge(i.get(0)[0], i.get(1)[0], i.get(0)[1]));
				// adding (pen1, pen2, cost)
			}
			
			else
				arr.add(new edge(i.get(0)[0], z, i.get(0)[1]));{
				// adding (pen1, outside (pen z), cost)
				}
		}
		
		Collections.sort(arr);
		
		parents = new int[z + 1];
		Arrays.fill(parents, -1);
		
		// make mst that first does not include the outside pen
		// if it is a valid mst (if all the pens are able to be connected), 
		// then return that value as cost1
		// if all the pens cannot be connected, then re-make mst with the outside pen this time
		// output this new cost as cost 2
		// return min(cost1, cost2) as final answer
		
		int count = 0;
		ArrayList<edge> mst = new ArrayList<edge>();
		for (edge i: arr) {  // check if we can connect all pens without going outside
			if (i.ev == z) continue; 
			int bvroot = find(i.bv);
			int evroot = find(i.ev);
			
			if (bvroot != evroot) {
				union(bvroot, evroot);
				mst.add(i);
				count += i.cost;
				if (mst.size() == z - 1) {
					break;
				}
			}
		}
		
		int count2 = 0;
		mst.clear();
		Arrays.fill(parents, -1);
		for (edge i: arr) {  // check if we let all the animals outside
			int bvroot = find(i.bv);
			int evroot = find(i.ev);
			
			if (bvroot != evroot) {
				union(bvroot, evroot);
				mst.add(i);
				count2 += i.cost;
				if (mst.size() == z) { // all pens are connected to the outside
					break;		
				}
			}
		}
			
		System.out.println(Math.min(count, count2));
			
		
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