package ccc;

import java.io.*;
import java.util.*;
public class CCC03S3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class coor {
		public int row;
		public int col;
		
		public coor(int row, int col) {
			this.row = row;
			this.col = row;
		}
		
		 
	}

	public static void main(String[] args) throws IOException {
		int blocks = readInt();
		int rowmax = readInt();
		int colmax = readInt();
		
		char[] graph[] = new char[rowmax][colmax];
		for (int i = 0; i < rowmax; i++) {
			graph[i] = readLine().toCharArray();
		}
		coor start = new coor(rowmax / 2, colmax / 2);
		coor roomstart = findRoom(start);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (roomstart.row != -1 && roomstart.col != -1) {
			arr.add(bfs(roomstart));
		}

		
		
		
	}
	
	public static int graph[];
	public static coor directions[];
	
	public static coor findRoom(coor start) {
		
		LinkedList<coor> q = new LinkedList<coor>();
		q.add(start);
		while (!q.isEmpty()) {
			coor cur = q.poll();
			int row = cur.row;
			int col = cur.col;
			
			
		}
		return new coor(0, 0);
		
	}
	
	public static int bfs(coor start) {
		return 0;
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
