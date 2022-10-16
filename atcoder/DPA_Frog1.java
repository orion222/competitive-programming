package atcoder;


// https://dmoj.ca/problem/dpa
import java.io.*;
import java.util.*;
public class DPA_Frog1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int[] h;
	public static int[] memo;
	public static int n;
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		
		h = new int[n];
		for (int i = 0; i < n; i++) h[i] = readInt();
		
		memo = new int[n];
		memo[1] = Math.abs(h[1] - h[0]);
		
		if (n == 1) System.out.println(h[0]);
		
		else if (n == 2) System.out.println(memo[1]);
		
		else System.out.println(jump(2));
	
		
	}
	
	public static int jump(int i) {
		memo[i] = Math.min(memo[i - 1] + Math.abs(h[i] - h[i - 1]), memo[i - 2] + Math.abs(h[i] - h[i - 2]));
		
		if (i == n - 1) return memo[i];
		
		return jump(i + 1);
		
		
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
