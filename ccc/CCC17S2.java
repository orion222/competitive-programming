package ccc;

import java.io.*;
import java.util.*;
public class CCC17S2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = readInt();
			
		}
		
		Arrays.sort(arr);
		
		int mid = n / 2;
		
		if (n % 2 == 0) {
			for (int i = 0; i < mid; i++) {
				System.out.print(arr[mid - 1 - i] + " " + arr[mid + i]);
				if (i < mid - 1) {
					System.out.print(" ");
				}
			}
		}
		
		else {
			for (int i = 0; i < mid; i++) {
				System.out.print(arr[mid - i] + " " + arr[mid + 1 + i]);
				System.out.print(" ");
				}
			System.out.print(arr[0]); 
			// since we start from the middle of an odd sequence
			// there will be an extra low tide measurement
			// we print this one out at the very end; we cannot omit it 
			

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
