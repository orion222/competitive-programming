package dmopc;

import java.io.*;
import java.util.*;
public class dmopc13c3p2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// FRUITY QUESTION NOT DOING 
		
		int s = readInt();
		
		String date = next();
		String time = next();
		
		int[] mth = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int years = Integer.parseInt(date.substring(0, 4));
		int months = Integer.parseInt(date.substring(5, 7));
		
		
		int days = Integer.parseInt(date.substring(8, 10));
		
		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3, 5));
		int seconds = Integer.parseInt(time.substring(6, 8));
		
		
		int h = s % 24; // hours
		int d = s / 24; // days
		int m = 0;
		
		hours -= h;  // new hours
		if (hours <= 0) {
			hours += 24;  
			days--;
			if (days <= 0) {
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
