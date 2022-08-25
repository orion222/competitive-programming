package random;

import java.io.*;
import java.util.*;
public class SingleSourceShortestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	@SuppressWarnings("unchecked")
	
	
	// unfinished
	public static void main(String[] args) throws IOException {
		int v = readInt(); int e = readInt();
		
		int[][] distances = new int[v + 1][v + 1];
		for (int i = 1; i <= v; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
			distances[i][i] = 0;
		}
		
		
		
		ArrayList<Integer> adj[] = new ArrayList[v + 1];
		for(int i = 1; i <=v; i++)
			adj[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= v; i++) {
			int bv = readInt();
			int ev = readInt();
			int cost = readInt();
			
			adj[bv].add(ev);
			adj[ev].add(bv);
			distances[bv][ev] = cost;
			distances[ev][bv] = cost;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i: adj[cur]) { // for each neighbor of cur
				int cost = distances[cur][i];
				//if (cost +  < + distances[cur][])
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
