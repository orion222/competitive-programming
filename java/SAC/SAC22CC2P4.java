package SAC;

// https://dmoj.ca/problem/sac22cc2p4

import java.io.*;
import java.util.*;
public class SAC22CC2P4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		char[][] graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			graph[i] = next().toCharArray();
		}
		
		int[][] step = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(step[i], Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		if (graph[0][0] == 'C') {
			pq.add(new Node(0, 0, 1));
			step[0][0] = 1;
		}
		else {
			pq.add(new Node(0, 0, 0));
			step[0][0] = 0;
		}
		
		int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int row = cur.row;
			int col = cur.col;
			int cost = cur.cost;
			if (cur.cost > step[row][col]) continue;
			for (int[] dir: directions) {
				int nrow = row + dir[0];
				int ncol = col + dir[1];
				if (0 <= nrow && nrow < n && 0 <= ncol && ncol < m) {				
					
					// if there is a cookie, we need to add 1 to the distance
					if (graph[nrow][ncol] == 'C' && step[nrow][ncol] > step[row][col] + 1) {
						step[nrow][ncol] = step[row][col] + 1;
						pq.add(new Node(nrow, ncol, step[nrow][ncol]));

					}
					// if there isn't a cookie, then we take the previous distance
					else if (graph[nrow][ncol] == '.' && step[nrow][ncol] > step[row][col]){
						step[nrow][ncol] = step[row][col];
						pq.add(new Node(nrow, ncol, step[nrow][ncol]));


					}
						
				}
			}
				
		}	
		System.out.println(step[n - 1][m - 1]);
			
		
	}

	
	
	public static class Node implements Comparable<Node>{
		int row;
		int col;
		int cost;
		public Node (int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
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
