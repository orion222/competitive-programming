package ccc;

import java.io.*;
import java.util.*;
public class CCC18S2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static int n;
	public static int[][] graph;
	public static void main(String[] args) throws IOException {
		n = readInt();
		graph = new int[n][n];
		
		int startX = 0;
		int startY = 0;
		
		int min = Integer.MAX_VALUE;
		int[] position = new int[2];
		for (int i = 0; i < n; i++) {
			int[] temp = new int[n];
			for (int x = 0; x < n; x++) {
				temp[x] = readInt();
				if (temp[x] < min) {
					min = temp[x];
					startX = x;
					startY = i;
					
				}
			}
			graph[i] = temp;
		}
		printTable(startX, startY);

	}
	
	// prints the table according to the smallest value in the table.
	// the smallest value will always be in the top-left corner, so 
	// it finds the position of the smallest value and prints the 
	// orientation of the table according to that.
	public static void printTable(int startX, int startY) {
		
		// has not been rotated
		if (startX == 0 && startY == 0) {
			for (int i = 0; i < n; i++) {
				for (int x = 0; x < n; x++) 
					System.out.print(graph[i][x] + ((x == n - 1)? "": " "));
				System.out.print((i == n - 1) ? "": "\n");
			}
		}
		
		
		// its been rotated 90 degrees clockwise
		else if (startX == n - 1 && startY == 0) {
			for (int i = n - 1; i >= 0; i--) {
				for (int x = 0; x < n; x++) 
					System.out.print(graph[x][i] + ((x == n - 1)? "": " "));
				System.out.print((i == 0) ? "": "\n");
			}
		}
		
		// its been rotated 180 degrees 
		else if (startX == n - 1 && startY == n - 1) {
			for (int i = n - 1; i >= 0; i--) {
				for (int x = n - 1; x >= 0; x--) 
					System.out.print(graph[i][x] + ((x == 0)? "": " "));
				System.out.print((i == 0) ? "": "\n");
			}
		}
		
		// its been rotated 270 degrees
		else if (startX == 0 && startY == n - 1) {
			for (int i = 0; i < n; i++) {
				for (int x = n - 1; x >= 0; x--) 
					System.out.print(graph[x][i] + ((x == 0)? "": " "));
				System.out.print((i == n - 1) ? "": "\n");
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
