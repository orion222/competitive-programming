package dmoj;

import java.io.*;
import java.util.*;
public class toospooky4me {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class event implements Comparable<event>{
		public int spooky;
		public int start;
		
		public event(int spooky, int start) {
			this.spooky = spooky;
			this.start = start;
		}
		
		public int compareTo(event o) {
			
			return Integer.compare(this.start, o.start);
						
		}
		
		public String toString() {
			return this.spooky + " " + this.start;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(); int l = readInt(); int s = readInt();

		event[] events = new event[n*2+1];
		
		for (int i = 0; i < n; i++) {
			int a = readInt(); int b = readInt(); int spook = readInt();
			events[i*2+1] = new event(spook, a);
			events[i*2] = new event(-spook, b + 1);
		}
		
		events[n*2] = new event(Integer.MAX_VALUE, l+1);
		Arrays.sort(events);
		
		int[] psa = new int[2*n+1];
		
		
		System.out.println();
		for (event i: events)
			System.out.print(i + ", ");
		System.out.println();
		
		
		
		for (int i = 0; i < 2*n + 1; i++) {
			if (i == 0) {
				psa[0] = events[i].spooky;
			}
			else {
				psa[i] = events[i].spooky + psa[i-1];

			}
		}
		
		for (int i = 0; i < psa.length; i++)
			System.out.print(psa[i] + " ");
		
		
		int count = 0;
		for(int i = 0; i < 2*n + 1; i++) {

			if (psa[i] < s) {
				count += Math.abs(events[i].start - events[i+1].start);
			}
		}
		
		count += Math.abs(1 - events[0].start);
		System.out.println(count);
		
		
		
			
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
