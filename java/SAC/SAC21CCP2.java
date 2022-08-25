package SAC;

// https://dmoj.ca/problem/sac21ccp2

import java.io.*;
import java.util.*;
public class SAC21CCP2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(); int k = readInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		
		
		long sum = 0;
		for (int i = 0; i < n; i++) pq.add(readLong());
		for (int i = 0; i < k; i++) sum += pq.poll();
		System.out.println(sum);
		
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
