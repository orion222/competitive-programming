package dmoj;


// finish later
// https://dmoj.ca/problem/rollencrypt
import java.io.*;
import java.util.*;
public class RollingEncryption {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int k = readInt();
		char[] arr = readLine().toLowerCase().toCharArray();
		String output = new String(arr);
		output = output.substring(0, k);

		// 97 is ASCII for 'a'
		int[] freq = new int[27];
		
		
		char[] alpha = ("-abcdefghijklmnopqrstuvwxyz").toCharArray();
		int max = 1;
		int count = 0;
		
		System.out.println(max);
		
		for (int i = k; i < arr.length; i++) {

			
			int cur = ((int)arr[i] - 96);
			
			
			// try saving the array and only computing the next term to save space
			for (int x = i - 1; x > 0 + i - i; x--) {
				int ind = (int)arr[x] - 96;
				freq[ind] += 1;
				if (freq[ind] > max || (freq[ind] == freq[max] && ind < max)) {
					max = ind; // max is the numbering of the letters (a - 1, b - 2, c - 3)
				}
			}

			freq[cur] += 1;
			int update = ((int)arr[i] - 96 + max) % 26;

			output += alpha[update];
			count++;

		}

		System.out.println(output);
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
