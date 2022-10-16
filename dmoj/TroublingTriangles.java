package dmoj;


import java.io.*;
import java.util.*;
public class TroublingTriangles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class info {
		public double p;
		public double a;
		
		public info(double p, double a) {
			this.p = p;
			this.a = a;
		}
	}
	public static void main(String[] args) throws IOException {
		
		int q = readInt();
		
		info[] arr = new info[q];
		for (int i = 0; i < q; i++) {
			
			double x1 = readInt();
			double y1 = readInt();
			double x2 = readInt();
			double y2 = readInt();
			double x3 = readInt();
			double y3 = readInt();
			
			double sidea = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2,  2));
			double sideb = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y1 - y3,  2));
			double sidec = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y2 - y3,  2));
			double p = sidea + sideb + sidec;
			double s = p / 2;
			double a = Math.sqrt(s * (s - sidea) * (s - sideb) * (s - sidec));
			arr[i] = new info(p, a);

		}
		
		for (info e: arr)
			System.out.printf("%.2f %.2f%n", e.a, e.p);
		
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
