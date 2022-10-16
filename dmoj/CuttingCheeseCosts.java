package dmoj;

import java.io.*;
import java.util.*;

public class CuttingCheeseCosts {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class ele implements Comparable<ele>{
		public int originalPrice;
		public int difference;
		
		public ele(int originalPrice, int difference) {
			this.originalPrice = originalPrice;
			this.difference = difference;
		}
		
		public int compareTo(ele o) {
			if (this.difference > o.difference)
				return 1;
			else if (this.difference < o.difference)
				return -1;
			else
				return 0;
		}
		
		public String toString() {
			return "(" + originalPrice + ", " + difference + ")";
		}
	}
	
	public static void main(String[] args) throws IOException{
		int n = readInt(); int k = readInt();
		
		List<ele> arr = new ArrayList<ele>();

		for (int i = 0; i < n; i++) {
			int p = readInt(); int d = readInt();
			int z = p - d;
			arr.add(new ele(p, z));
			
		}
		
		Collections.sort(arr);
		long total = 0;
		for (int i = n - 1; i > n - 1 - k; i--) {
			ele cur = arr.get(i);
			int diff = cur.difference;
			int og = cur.originalPrice;
			total += og - diff;
			
		}
		
		for (int i = n - 1 - k; i >= 0; i--) {
			ele cur = arr.get(i);
			int og = cur.originalPrice;
			total += og;
		}
		
		// [(2, 3), (30, 4), (50, 40), (40, 40)]
	

		System.out.println(total);
			
		
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
