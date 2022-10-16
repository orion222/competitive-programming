package random;

import java.io.*;
import java.util.*;
public class DMPG17S2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		
		int[] parents = new int[n + 1];
		
		Arrays.fill(parents, -1);
		
		for (int i = 0; i < q; i++) {
			
			
			char order = readCharacter();
			int bv = readInt();
			int ev = readInt();
			
			int bvroot = find(bv, parents);
			int evroot = find(ev, parents);
			if (order == 'A' && bvroot != evroot) {
				union(bvroot, evroot, parents);
			}
			
			else if (order == 'Q') {
				System.out.println((bvroot == evroot) ? "Y": "N");
				
			}
			
		}

	}
	
	
	public static int find(int v, int[] parents) {
		if (parents[v] == -1) {
			return v;
		}
		
		parents[v] = find(parents[v], parents);
		return parents[v];
	}
	
	public static void union(int bv, int ev, int[] parents) {
		parents[bv] = ev;
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
