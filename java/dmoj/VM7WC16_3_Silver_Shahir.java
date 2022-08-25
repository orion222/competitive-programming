package dmoj;

import java.io.*;
import java.util.*;
public class VM7WC16_3_Silver_Shahir {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int a = readInt();
		int b = readInt();
		
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int bv = readInt(); // beginning vertex
			int ev = readInt(); // ending vertex
			
			// roads are bi-directional, so you need to set both positions to 1
			graph[bv][ev] = 1;
			graph[ev][bv] = 1;
		}
		

		
		int[] distances = new int[n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[a] = 0;
		
		boolean possible = false;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(a);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == b) {
				possible = true;
				break;
			}
			for (int c = 1; c <= n; c++) {
				if (graph[cur][c] == 1 && distances[cur] + 1 < distances[c]) {
					distances[c] = distances[cur] + 1;
					queue.add(c);
				}
			}
		}
		
		if (possible || a == b) {
			System.out.println("GO SHAHIR!");
		}
		else {
			System.out.println("NO SHAHIR!");
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
