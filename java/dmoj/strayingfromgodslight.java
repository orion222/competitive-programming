package dmoj;

import java.io.*;
import java.util.*;
public class strayingfromgodslight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static class vec {
		public int d;
		public int l;
		public int r;
		
		public vec (int d, int l, int r) {
			this.d = d;
			this.l = l;
			this.r = r;
			
		}
		
		public boolean equals(vec o) {
			return this.d == o.d && this.l == o.l && this.r == o.r;
		}
	}
	
	public static class coor {
		public int row;
		public int col;
		
		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public boolean equals(coor o) {
			return this.row == o.row && this.col == o.col;  
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		char[] graph[] = new char[n][n];
		vec[] distances[] = new vec[n][n];
		
		for (int i = 0; i < n; i++) {
			graph[i] = readLine().toCharArray();
		}
		
		for (vec[] i: distances) Arrays.fill(i, new vec(-1, -1, -1));
		distances[0][0] = new vec(0, 0 ,0);
		
		vec out = bfs(graph, distances, n);
		System.out.println(out.d + " " + out.l + " "+  out.r);

		if (out.equals(new vec(-1, -1, -1)))
			System.out.println(-1);
		
		else
			System.out.println(Math.pow(out.d, 2) + Math.pow(out.l, 2) + Math.pow(out.r, 2));
		
		
	}
	
	public static vec bfs(char[] graph[], vec[] distances[], int n) {
		
		LinkedList<coor> queue = new LinkedList<coor>();
		queue.add(new coor(0, 0));
		coor[] directions = {new coor(1, 0), new coor(0, -1), new coor(0, 1)};
		while (!queue.isEmpty()) {
			coor cur = queue.poll();
			int row = cur.row;
			int col = cur.col;
			
			if (cur.equals(new coor (n - 1, n - 1)))
				return distances[n - 1][n - 1];
			
			for (int i = 0; i < 3; i++) {
				int nrow = row + directions[i].row;
				int ncol = col + directions[i].col;
				if (0 <= nrow && nrow < n && 0 <= ncol && ncol < n && graph[nrow][ncol] != '#' && distances[nrow][ncol].equals(new vec(-1, -1, -1))) {
					queue.add(new coor(nrow, ncol));
					
					if (i == 0)
						distances[nrow][ncol] = new vec (distances[row][col].d + 1, distances[row][col].l, distances[row][col].r);
					else if (i == 1)
						distances[nrow][ncol] = new vec (distances[row][col].d, distances[row][col].l + 1, distances[row][col].r);
					else
						distances[nrow][ncol] = new vec (distances[row][col].d, distances[row][col].l, distances[row][col].r + 1);
				}
				
			}
				
			
		}
		
		
		return new vec(-1, -1, -1);
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
