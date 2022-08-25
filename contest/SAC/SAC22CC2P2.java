package SAC;

import java.io.*;
import java.util.*;
public class SAC22CC2P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(); int q = readInt();
		
		int sum = 0;
        // tank will store the number of cookies in (x, y)
		int[][] tank = new int[n + 1][n + 1];
		
		for (int i = 0; i < q; i++) {
			int operation = readInt();
			
            // increment the number of cookies at (x, y) since we are 
            // placing one inside this coordinate
			if (operation == 1) {
				tank[readInt()][readInt()]++;
			}
			
			else if (operation == 2) {
				int x1 = readInt(); int y1 = readInt();
				int x2 = readInt(); int y2 = readInt();
				
				for (int r = y1; r <= y2; r++) {
					for (int c = x1; c <= x2; c++) {
			            // tank[c][r] could have 2 cookies
                        // we can just add 2 since this iteration would put 1 sprinkle
                        // on each of those cookies, so it would increment the total
                        // sprinkles by 2, which is equal to the number of cookies at (c, r)
						sum += tank[c][r];
					}
				}
			}
		}
		
		System.out.println(sum);

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
