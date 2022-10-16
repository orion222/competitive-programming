package ccc;

import java.io.*;
import java.util.*;
public class test {
	
		
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		char[][] map = new char[4][5];
		for (int i = 0; i < rows; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		int[][] distances = new int[4][5];
		for (int i = 0; i < 4; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		}
		distances[0][0] = 0;
		
		LinkedList<Coordinate> q = new LinkedList<Coordinate>();
		q.add(new Coordinate(0, 0));
		
		while (!q.isEmpty()) {
			Coordinate cur = q.poll();
			int r = cur.row;
			int c = cur.col;
			
			// going up
			if (r - 1 >= 0 && map[r - 1][c] != 'X' && distances[r][c] + 1 < distances[r - 1][c]) {
				q.add(new Coordinate(r - 1, c));
				distances[r - 1][c] = distances[r][c] + 1;
			}
			// going down
			if (r + 1 < rows && map[r + 1][c] != 'X' && distances[r][c] + 1 < distances[r + 1][c]) {
				q.add(new Coordinate(r + 1, c));
				distances[r + 1][c] = distances[r][c] + 1;
			}
			// going left
			if (c - 1 >= 0 && map[r][c - 1] != 'X' && distances[r][c] + 1 < distances[r][c - 1]) {
				q.add(new Coordinate(r, c - 1));
				distances[r][c - 1] = distances[r][c] + 1;
			}
			// going right
			if (c + 1 < cols && map[r][c + 1] != 'X' && distances[r][c] + 1 < distances[r][c + 1]) {
				q.add(new Coordinate(r, c + 1));
				distances[r][c + 1] = distances[r][c] + 1;
			}
		}
		
		System.out.println(distances[rows - 1][cols - 1]);
		
		
		
			
	}
	
	public static class Coordinate {
		int row;
		int col;
		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	
}









