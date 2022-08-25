package mockccc;


// https://dmoj.ca/problem/nccc2j2
import java.io.*;
import java.util.*;
public class mockCCC18C2J2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static int n;
	public static int m;
	public static char[][] matrix;
	
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		m = readInt();
		matrix = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			matrix[i] = readLine().toCharArray();
		}
		
	    System.out.println(Arrays.deepToString(matrix));
		
		for (int i = 0; i < 100; i++) {
			function();
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				System.out.print(matrix[r][c]);
			}
			System.out.println();
		}

	}
	
	public static void function() {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++){
				if (matrix[r][c] == 'o') {
					if (r + 1 < n && matrix[r + 1][c] == '.') {
						matrix[r][c] = '.';
						matrix[r + 1][c] = 'o';
					}
				}
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
