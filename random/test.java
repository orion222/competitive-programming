package random;

import java.io.*;
import java.util.*;
public class test {

	public static char[][] matrix;

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}	
	  


	public static void function(int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++){
				if (r != rows - 1 && matrix[r][c] == 'o' && matrix[r + 1][c] == '.') {
					matrix[r][c] = '.';
					matrix[r + 1][c] = 'o';
				}
				
			}
		}
	}
		
	
}
