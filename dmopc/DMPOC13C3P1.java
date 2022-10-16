package dmopc;

import java.io.*;
import java.util.*;
public class DMPOC13C3P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		long n = readLong(); int m = readInt();
		ArrayList<String[]> arr = new ArrayList<String[]>();
		for (int i = 0; i < m; i++) {
			long p = readLong(); long q = readLong();
			String name = readLine();
			arr.add(new String[] {name, q + ""});
		}
		
		String me = readLong() + "";
		for (String[] i: arr) {
			if (i[1].equals(me)) System.out.println(i[0]);
			
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
