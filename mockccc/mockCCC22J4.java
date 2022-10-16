package mockccc;

import java.io.*;
import java.util.*;


public class mockCCC22J4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class bracket implements Comparable<bracket>{
		public int country;
		public int score; 
		
		public bracket(int country, int score) {
			this.country = country;
			this.score = score;
		}
		
		public int compareTo(bracket o) {
			int lean = -Integer.compare(score, o.score);
			
			if (lean == 0) {
				return Integer.compare(country, o.country);
			}
			return lean;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		int n = readInt(); int s = readInt();
		bracket[] all = new bracket[n + 1];
		
		
		ArrayList<bracket[]> andy = new ArrayList<bracket[]>();
		for (int x = 0; x < n / s; x++) { // for each group of countries
			bracket[] ranking = new bracket[s];
			
			for (int i = 0; i < s; i++) {	// input for each group
				int a = readInt();
				ranking[i] = new bracket(a, 0);
				all[a] = ranking[i];
		
			}
			andy.add(ranking);
		}
		
		
		
		for (int i = 0; i < ((s - 1) * n) / 2; i++) {
			int a = readInt(); int b = readInt(); String score = next();
			
			if (score.equals("W")) 
				all[a].score += 3;
			
			else if (score.equals("L"))
				all[b].score += 3;

			else
			{
				all[a].score += 1;
				all[b].score += 1;
			}
		}
		
		
		
		int k = readInt();
		
		for (int i = 0; i < andy.size(); i++) {
			
			/*
			for (bracket z: andy.get(i)) {
				System.out.print("" + z.country + " " + z.score + " ");
			}
			*/
			Arrays.sort(andy.get(i));
			System.out.print(andy.get(i)[k - 1].country + ((i+ 1 == n/s)?"":" "));
			
		}
		System.out.println();
			
		
			
		
		
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

