package dmoj;

// https://dmoj.ca/problem/faircompetition
import java.io.*;
import java.util.*;
public class FairCompetition {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int m = readInt();
		int n = readInt();
		
		int[] freq = new int[76];
		
		for (int i = 0; i < m; i++) {
			freq[readInt()] ++;
		}
		
		int max = 0;
		for (int i = 75; i >= 0; i--) {
			if (max + freq[i] > n) {
				break;
			}
			max += freq[i];
		}
		
		System.out.println(max);

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
