package dmopc;

import java.io.*;

// https://dmoj.ca/problem/dmopc15c6p3
import java.util.*;
public class DMOPC15C6P3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		int m = readInt();
		int k = readInt();
		
		// potatos per row
		int[] potatos = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			int a = readInt();
			int b = readInt();
			for (int x = 1; x < a; x++) {
				potatos[x] ++;
			}
			
			if (b < n) {
				for (int x = b + 1; x <= n; x++) {
					potatos[x] ++;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i: potatos) {
			pq.add(i);
		}
		
		int w = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			if (sum >= k) {
				System.out.println(w);
				return;
			}
			else {
				sum += pq.poll();
				w++;
			}
		}
		
		System.out.println(-1);

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
