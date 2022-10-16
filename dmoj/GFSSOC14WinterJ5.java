package dmoj;

// https://dmoj.ca/problem/gfssoc1j5
// editorial the goat..

import java.io.*;
import java.util.*;
public class GFSSOC14WinterJ5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static ArrayList<Integer>[] adj;
	public static int[][] dist;
	public static int t;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		t = readInt();
		
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++)
			adj[readInt()].add(readInt());
		
		dist = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) 
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		for (int i = 1; i <= n; i++) {
			dist[i][i] = 0;
			bfs(i);
		}
		
		int Q = readInt();
		for (int i = 0; i < Q; i++) {
			int a = readInt();
			int b = readInt();
			if (dist[a][b] == Integer.MAX_VALUE) {
				System.out.println("Not enough hallways!");
			}
			else
				System.out.println(Math.abs(dist[a][b]));
		}
		
	}
	
	public static void bfs(int root) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i: adj[cur]) {
				if (dist[root][cur] + t < dist[root][i]) {
					dist[root][i] = dist[root][cur] + t;
					q.add(i);
				}
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
