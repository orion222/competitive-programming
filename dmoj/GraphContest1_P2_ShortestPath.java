package dmoj;

// https://dmoj.ca/problem/graph1p2
import java.io.*;
import java.util.*;
public class GraphContest1_P2_ShortestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] graph = new int[n][n];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				graph[r][c] = readInt();
			}
		}
		
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int c = 0; c < n; c++) {
				if (graph[cur][c] == 1 && distances[cur] + 1 < distances[c]) {
					distances[c] = distances[cur] + 1;
					q.add(c);
				}
			}
			
		}
		
		System.out.println(distances[n - 1]);
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
