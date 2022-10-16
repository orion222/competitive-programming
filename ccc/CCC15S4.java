package ccc;


import java.io.*;
import java.util.*;
public class CCC15S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static class Node implements Comparable<Node>{
		public int bv;
		public int ev;
		public int cost;
		public int hull;
		
		public Node(int ev, int cost, int wear) {
			this.ev = ev;
			this.cost = cost;
			this.hull = wear;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int k = readInt(); int V = readInt(); int E = readInt();
		
		ArrayList<Node>[] adjList = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) adjList[i] = new ArrayList<Node>();
		
		for (int i = 0; i < E; i++) {
			int a = readInt(); int b = readInt(); int c = readInt(); int d = readInt();
			adjList[a].add(new Node(b, c, d));
			adjList[b].add(new Node(a, c, d));
		}
		
		int start = readInt();
		int end = readInt();
		
		int[][] dist = new int[V + 1][k + 1]; 
		// store the cost in each wear value by index
		for (int i = 0; i < V + 1; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[start][0] = 0;

		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0, k)); // start the q with the maximum strength the hull has
		
		while (!pq.isEmpty()) {
			int v = pq.peek().ev;
			int cost = pq.peek().cost;
			int curHull = pq.peek().hull;
			pq.poll();
			if (v == end) {
				System.out.println(cost);
				return;
			}
			if (cost > dist[v][curHull]) continue;
			
			for (Node i: adjList[v]) {
				if (curHull > i.hull && dist[i.ev][curHull - i.hull] > cost + i.cost) {
					pq.add(new Node(i.ev, cost + i.cost, curHull - i.hull));
					dist[i.ev][curHull - i.hull] = cost + i.cost; 
					
				}
			}
		}
		
		System.out.println(-1);

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
