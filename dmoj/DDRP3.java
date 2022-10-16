package dmoj;

// https://dmoj.ca/problem/ddrp3
import java.io.*;
import java.util.*;
public class DDRP3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int bv = readInt();
			int ev = readInt();
			if (bv == ev) continue;
			adj[bv].add(ev);
			adj[ev].add(bv);
		}
		
		int s = readInt();
		int t = readInt();
		
		int[] distances = new int[n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[s] = 0;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i: adj[cur]) {
				if (distances[cur] + 1 < distances[i]) {
					q.add(i);
					distances[i] = distances[cur] + 1;
					if (i == t)
						break;
				}
			}
		}
		
		System.out.println(m - distances[t]);
		
		
		
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	
}
