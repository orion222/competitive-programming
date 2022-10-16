package dmoj;


// https://dmoj.ca/problem/gfssoc1j5
import java.io.*;
import java.util.*;
public class GFSSOC14J5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(); int e = readInt(); int c = readInt();
		ArrayList<Integer> graph[] = new ArrayList[n + 1];
		for(int i = 1;i<=n;i++) graph[i] = new ArrayList<Integer>();
		for (int i = 1; i <= e; i++) {
			int bv = readInt(); int ev = readInt();
			graph[bv].add(ev);
			
		}
		
		int[] distances = new int[n + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		int q = readInt();
		for(int i = 0; i < q; i++) {
			int a = readInt(); int b = readInt();
			if (distances[a] != Integer.MAX_VALUE && distances[b] != Integer.MAX_VALUE)   
				// already computed values
				// but can this be faster if you only have 1 point computed?
				System.out.println(distances[b] - distances[a]);
			else {
				LinkedList<Integer> queue = new LinkedList<Integer>();
				
				while (queue.size() > 0) {
					int cur = queue.poll();
					for (int x = 0; x < graph[cur].size(); x++) {
						
					}
				}
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
