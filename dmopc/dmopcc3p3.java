package dmopc;


// https://dmoj.ca/problem/dmopc13c3p3
import java.io.*;
import java.util.*;
public class dmopcc3p3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static int n;
	public static int h;
	
	public static void main(String[] args) throws IOException {
		n = readInt(); h = readInt();
		int[][] graph = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int x = 0; x < n; x++) {
				graph[i][x] = readInt();
				visited[i][x] = false;
			}
		}
		
		if (bfs(graph, visited)) System.out.println("yes");
		else System.out.println("no");
	}
	
	public static boolean bfs(int[][] graph, boolean[][] visited) {
		
		int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		LinkedList<coor> q = new LinkedList<coor>();
		q.add(new coor(0, 0));
		
		while (!q.isEmpty()) {
			coor cur = q.poll();
			int crow = cur.row;
			int ccol = cur.col;
			int pos = graph[crow][ccol];
			
			if (crow == n - 1 && ccol == n - 1) {
				return true;
			}
			for (int[] i: dir) {
				int nrow = crow + i[0];
				int ncol = ccol + i[1];
				if (0 <= nrow && nrow < n && 0 <= ncol && ncol < n && !visited[nrow][ncol] && Math.abs(pos - graph[nrow][ncol]) <= h) {
					q.add(new coor(nrow, ncol));
					visited[nrow][ncol] = true;
				}
				
			}
			
		}
		return false;
	}
	
	public static class coor {
		public int row;
		public int col;
		
		public coor(int row, int col) {
			this.row = row;
			this.col = col;
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
