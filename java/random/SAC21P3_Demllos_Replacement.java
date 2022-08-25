package random;

import java.io.*;
import java.util.*;

public class SAC21P3_Demllos_Replacement {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class student implements Comparable<student>{
		public String name;
		public long score;
		
		public student(String name, long score) {
			this.name = name;
			this.score = score;
			
		}
		
		public int compareTo(student o) {
			return Long.compare(this.score, o.score);
		}
		
		public String toString() {
			return name + " " + score;
		}
			
		
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(); int p = readInt();
		
		student[] scores = new student[n];
		
		for (int i = 0; i < n; i++) {
			String name = next(); int m = readInt(); int cs = readInt(); int e = readInt();
			long score = (long) Math.floor(4 * Math.sqrt(m) + 3 * Math.pow(cs, p) - 4 * e);  
			scores[i] = new student(name, score);
			
		}
		
		Arrays.sort(scores);
		System.out.println(scores[n - 1]);
		System.out.println(scores[0]);
		
		
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