package ccc;

import java.io.*;
import java.util.*;
public class CCC22S2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int p = readInt();
		
		int count = 0;
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		
		ArrayList<Integer> must[] = new ArrayList[(int)1e5];
		ArrayList<Integer> mustnot[] = new ArrayList[(int)1e5];
		
		for (int i = 0; i < p; i++) {
			String name = next();
			String name2 = next();
			if (!names.containsKey(name)) {
				names.put(name, count);
				count++;
			}
			if (!names.containsKey(name2)) {
				names.put(name, count);
				count++;
			}
			must[names.get(name)].add(names.get(name2)); // only do for 1 to avoid double counting
		}
		
		for (int i = 0; i < p; i++) {
			String name = next();
			String name2 = next();
			if (!names.containsKey(name)) {
				names.put(name, count);
				count++;
			}
			if (!names.containsKey(name2)) {
				names.put(name, count);
				count++;
			}
			mustnot[names.get(name)].add(names.get(name2)); // only do for 1 to avoid double counting
		}
		
		int g = readInt();
		int total = 0;
		for (int i = 0; i < g; i++) {
			String[] arr = {next(), next(), next()};
			
	
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
