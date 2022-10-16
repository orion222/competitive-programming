package dmoj;
// https://dmoj.ca/problem/sssp

import java.io.*;
import java.util.*;
public class SingleSourceShortestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	
	public static class pair implements Comparable<pair>{
		public int ev;
		public int cost;
		
		public pair(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
		
		public int compareTo(pair o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	public static void main(String[] args) throws IOException {
		int n = readInt() + 1; int m = readInt();
		
		int[][] matrix = new int[n][n];
		for (int[] i: matrix) Arrays.fill(i, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int a = readInt(); int b = readInt(); int c = readInt();
			if (c < matrix[a][b]) { 
				matrix[a][b] = c; 
				matrix[b][a] = c;
			}
		}
		
		
		// dijkstra
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		
		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		pq.add(new pair(1, 0));
		while (!pq.isEmpty()) {
			pair cur = pq.poll();
			for (int i = 1; i < n; i++) {
				if (matrix[cur.ev][i] != Integer.MAX_VALUE) {
					if (dist[cur.ev] + matrix[cur.ev][i] < dist[i]) {
						dist[i] = dist[cur.ev] + matrix[cur.ev][i];
						pq.add(new pair(i, dist[i]));
					}
				}
			}
		
		}
		for (int i = 1; i < n; i++) 
			System.out.println((dist[i] == Integer.MAX_VALUE)? -1: dist[i]);
		
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
