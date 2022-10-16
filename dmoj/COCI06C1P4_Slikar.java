package dmoj;
// https://dmoj.ca/problem/coci06c1p4
import java.io.*;
import java.util.*;
public class COCI06C1P4_Slikar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class pos {
		public int row;
		public int col;
		
		public pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public String toString() {
			return this.row + " " + this.col;
		}
		
		public boolean equals(pos o) {
			return this.row == o.row && this.col == o.col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int rows = readInt(); int columns = readInt();
		
		char[][] graph = new char[rows][columns];
		
		pos start = new pos(0, 0);
		pos water = new pos(0, 0);
		pos end = new pos(0, 0);
		LinkedList<pos> waters = new LinkedList<pos>();
		
		for (int i = 0; i < rows; i++) {
			String row = readLine();
			graph[i] = row.toCharArray();
			for (int x = 0; x < columns; x++) {
				if (graph[i][x] == 'D')
					end = new pos(i, x);
				
				else if (graph[i][x] == 'S')
					start = new pos(i, x);
				
				else if (graph[i][x] == '*')
					waters.add(new pos(i, x));
			}
		}
		
		int[][] distances = new int[rows][columns];
		for (int[] row: distances)
			Arrays.fill(row,  -1);
		
		distances[start.row][start.col] = 0;
		
		LinkedList<pos> queue = new LinkedList<pos>();
		queue.add(start);		
		
		/*
		for(pos i: waters)System.out.println(i);
		System.out.println(start.row + " " + start.col);
		System.out.println(end.row + " " + end.col);
		System.out.println(water.row + " " + water.col);
		*/
		
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int output = -1;
		
		orion: while (!queue.isEmpty()) {
			LinkedList<pos> temp = new LinkedList<pos>();
			LinkedList<pos> temp2 = new LinkedList<pos>();

			// water flow first 
			
			while (!waters.isEmpty()) {
				pos w = waters.poll();
				for (int x = 0; x < 4; x++) {
					int nrow = w.row + dir[x][0];
					int ncol = w.col + dir[x][1];
					
					if (0 <= nrow && nrow < rows && 0 <= ncol && ncol < columns && graph[nrow][ncol] != 'X' 
							&& graph[nrow][ncol] != '*' && graph[nrow][ncol] != 'D') {
						graph[nrow][ncol] = '*';
						temp.add(new pos(nrow, ncol));
					}
				}
			}
			
			// position change
			
			while (!queue.isEmpty()) {
				pos cur = queue.poll();

				
				if (cur.equals(end)) {
					output = distances[cur.row][cur.col];
					break orion;
					
				}
				
				for (int i = 0; i < 4; i++) {
					int nrow = cur.row + dir[i][0];
					int ncol = cur.col + dir[i][1];
					
					if (0 <= nrow && nrow < rows && 0 <= ncol && ncol < columns && graph[nrow][ncol] != 'X' 
							&& graph[nrow][ncol] != '*' && distances[nrow][ncol] == -1) {
						distances[nrow][ncol] = distances[cur.row][cur.col] + 1;
						temp2.add(new pos(nrow, ncol));
					}
					
				}
			}
			

			
			for (pos i: temp)  // filling water coordinates for the next minute
				waters.add(i);
			for(pos i: temp2)
				queue.add(i);

		}
		
		if (output == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(output);
		
		
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
