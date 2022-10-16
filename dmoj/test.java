package dmoj;

import java.util.*;
import java.io.*;
 
public class test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        
    	System.out.println((int)'a');
    }
    public static class Pair implements Comparable<Pair>{
        int weight, node;
        
        public Pair (int first, int second) {
            this.weight = first;
            this.node = second;
        }
        public int compareTo (Pair p) {
            return Integer.compare(this.weight, p.weight);
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
