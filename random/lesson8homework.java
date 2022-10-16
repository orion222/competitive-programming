package random;

import java.io.*;
import java.util.*;
public class lesson8homework {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		
	}
	
	public static void task1() {
		// adjacency matrix
		int[][] adjMatrix = new int[6][6];
		
		for (int i = 0; i < 8; i++) {
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			adjMatrix[bv][ev] = 1;
		}
		
		
		// adjacency list
		ArrayList<Integer>[] adjList = new ArrayList[6];
		for (int i = 0; i < 6; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < 8; i++) {
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			adjList[bv].add(ev);
		}

	}
	
	public static void task2() {
		// adjacency matrix
		int[][] adjMatrix = new int[5][5];
		
		
		// [0, 1, 2, 3]
		
		
		for (int i = 0; i < 5; i++) {
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			adjMatrix[bv][ev] = 1;
			adjMatrix[ev][bv] = 1;
		}
		
	}
	
	

	
}
