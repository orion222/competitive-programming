package algos;

import java.io.*;
import java.util.*;
public class fenwicktree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		
		int n = readInt(); int m = readInt();
		int[] arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = readInt();
			
		}

		
		
		long[] bit = new long[n + 1];
		long[] bit2 = new long[(int) (1E5 + 1)];
		
		// init bit
		for (int i = 1; i <= n; i++) {
			update(i, arr[i], bit);
			update(arr[i], 1, bit2);
		}
		
		
		
		for (int i = 0; i < m; i++) {
			String[] q = readLine().split(" ");
			
			// change the xth element to y
			if (q[0].equals("C")) {
				int x = Integer.parseInt(q[1]);
				int y = Integer.parseInt(q[2]);
				
				long a = freqTo(x, bit);
				long b = freqTo(x - 1, bit);
				update(x, y - (a - b), bit);
				update((int) (a - b), -1, bit2);
				update(y, 1, bit2);
			}
			
			
			
			
			// sum up elements in a range
			else if (q[0].equals("S")) {
				long toX = freqTo(Integer.parseInt(q[2]), bit);
				long toZ = freqTo(Integer.parseInt(q[1]) - 1, bit); // inclusive
				System.out.println(toX - toZ);
				
			}
			
			else if (q[0].equals("Q")) {
				long equalTo = freqTo(Integer.parseInt(q[1]), bit2);
				System.out.println(equalTo);
			}
		}

	}
	
	
	public static long freqTo(int index, long[] tree) {
		long sum = 0;
		for (int i = index; i > 0; i-=(i&-i)) {
			sum += tree[i];
		}
		
		return sum;
	}
	
	public static void update(int index, long val, long[] tree) {
		
		for (int i = index; i < tree.length; i+=(i&-i)) {
			tree[i] += val;
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

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
