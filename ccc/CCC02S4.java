package ccc;

// https://dmoj.ca/problem/ccc02s4 
import java.io.*;
import java.util.*;
public class CCC02S4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int m = readInt();
	    int q = readInt();
	  
	  
	    String[] n = new String[105];
	    int[] d = new int[105];
	    for (int i = 1; i <= q; i++) {
	    	n[i] = next();
	    	d[i] = readInt();
	    }	
	  
	    // fastest time for the first n people
	    int[] memo = new int[105];
	    int[] group = new int[105];
	  
		// names of group i
		ArrayList<String>[] names = new ArrayList[105];
		for (int i = 1 ; i <= q; i++) names[i] = new ArrayList<String>();
		  
		// start from 1 person, add 1 person every time
		for (int i = 1; i <= q; i++) { 
			int cur = d[i];
		    
		    // if we do not group this person at all
			int leastTime = cur + memo[i - 1];
			int curGroupTime = cur; // time it takes for current group to cross bridge
		
			group[i] = i;
			// [x - i] is the range of the group
			for (int x = i - 1; x > i - m; x--) {
				if (x < 1) break;
				  // group[i] = j means that there is a group from [j - i]
				
				  // starting at the back
				  // group[5] = 4 how we know [4 - 5]
				
				  // then looking at group[3] = 2
				  // we know we have a group from [2 - 3]
				
				  // then we look at group[1] = 1
				  // we know we have a group from [1 - 1]
				curGroupTime = Math.max(curGroupTime, d[x]);
				// if leastTime is improved store the value of x (somewhere)
				if (memo[x - 1] + curGroupTime < leastTime) {
					group[i] = x;
				}
				leastTime = Math.min(memo[x - 1] + curGroupTime, leastTime);
			  
			}
			memo[i] = leastTime;
			System.out.println();
			for(int j = 0; j <= q; j++)
				System.out.print(group[j] + " ");
	  }
			  
	  System.out.println("Total time: " + memo[q - 1]);
	  
	  int g = 1;
	  for (int i = 1; i <= q; i++) {
		  if (group[i + 1] == g) continue;
		  for (int x = group[i]; x <= i; x++) {
			  System.out.print(n[x] + " ");
		  }
		  System.out.println();
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
