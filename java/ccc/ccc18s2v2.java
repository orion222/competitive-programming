package ccc;

import java.io.*;
import java.util.*;
public class ccc18s2v2 {
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] table = new int[n][n];
		
		int lowestHeightRow = 0;
		int lowestHeightCol = 0;
		int minimum = Integer.MAX_VALUE;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n ; c++) {
				table[r][c] = sc.nextInt();
				if (table[r][c] < minimum) {
					minimum = table[r][c];
					lowestHeightRow = r;
					lowestHeightCol = c;
				}
			}
		}
		
		// if there is a rotation of 0 degrees
		
		if (lowestHeightRow == 0 && lowestHeightCol == 0) {
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(table[r][c] + " ");
				}
				System.out.println();
			}
		}
		else if (lowestHeightRow == 0 && lowestHeightCol == n - 1) {
			for (int r = n - 1; r >= 0; r--) {
				for (int c = 0; c < n; c++) 
					System.out.print(table[c][r] +  " ");
				System.out.println();
			}
		}
		
		
		
		
		
		
	}


}
