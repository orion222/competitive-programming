package SAC;

// https://dmoj.ca/problem/sac22cc2p3
import java.io.*;
import java.util.*;
public class SAC22CC2P3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int startRating = readInt();
		int V = (int) Math.pow(2, n + 1); // number of vertices
		
		ArrayList<Node>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) adj[i] = new ArrayList<Node>();
		
		for (int i = 0; i < Math.pow(2, n) - 1; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			int d = readInt();
			adj[u].add(new Node(v, d));
			adj[u].add(new Node(w, 0));
			
		}
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[1] = startRating;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1, startRating));
		while (!pq.isEmpty()) {
			int bv = pq.peek().ev;
			int cost = pq.peek().cost;
			if (cost < dist[bv]) continue;
			pq.poll();
	        for (Node neighbor: adj[bv]){
	            if (dist[neighbor.ev] < neighbor.cost + cost){
	              dist[neighbor.ev] = neighbor.cost + cost;
	              pq.add(new Node(neighbor.ev, dist[neighbor.ev]));
	            }
          }
			
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < V; i++) {
			if (dist[i] > max) {
				max = dist[i];
			}
		}
		
		System.out.println(max);
		
	}
	
	public static class Node implements Comparable<Node>{
		int ev;
		int cost;
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
