package dmoj;

// https://dmoj.ca/problem/vmss7wc15c4p3
import java.io.*;
import java.util.*;
public class VM7WC15P4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(); int m = readInt();
		
		ArrayList<Node>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<Node>();
		for (int i = 0; i < m; i++) {
			int bv = readInt(); int ev = readInt(); int cost = readInt();
			adj[bv].add(new Node(ev, cost));
			adj[ev].add(new Node(bv, cost));

		}
		int[] fromstart = dijk(adj, 0);
		int[] fromend= dijk(adj, n - 1);
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (fromstart[i] + fromend[i] > max) 
				max = fromstart[i] + fromend[i];
		}

			
		System.out.println(max);
		
		
		
	}
	
	public static int[] dijk(ArrayList<Node>[] adj, int start) {

		int[] dist = new int[adj.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(start, 0));
		
		while (!q.isEmpty()) {
			int ev = q.peek().ev; 
			int cost = q.peek().cost;
			q.poll();
			if (cost > dist[ev]) continue;
			for (Node i: adj[ev]) {
				int nev = i.ev;
				int ncost = i.cost;
				if (dist[nev] > dist[ev] + ncost) {
					dist[nev] = dist[ev] + ncost;
					q.add(new Node(nev, dist[nev]));
				}
				
			}
			
		}
		
		return dist;
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