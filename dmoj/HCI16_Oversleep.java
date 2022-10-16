package dmoj;

import java.io.*;
import java.util.*;
public class HCI16_Oversleep {


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		char[][] map = new char[n][m];
		Coordinate start = new Coordinate(-1, -1);
		Coordinate end = new Coordinate(-1, -1);;
		for (int i = 0 ; i < n; i++) {
			map[i] = sc.next().toCharArray();
			for (int x = 0; x < m; x++) {
				if (map[i][x] == 's') {
					start = new Coordinate(i, x);
				}
				else if (map[i][x] == 'e') {
					end = new Coordinate(i, x);
				}
			}
		}
		
		int[][] distances = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		}
		
		distances[start.row][start.col] = 0;
		
		LinkedList<Coordinate> q = new LinkedList<Coordinate>();
		q.add(start);
		
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
			if (r + 1 < n && map[r + 1][c] != 'X' &&distances[r][c] + 1 < distances[r + 1][c]) {
				q.add(new Coordinate(r + 1, c));
				distances[r + 1][c] = distances[r][c] + 1;
			}
			
			// going left
			if (c - 1 >= 0 && map[r][c - 1] != 'X' && distances[r][c] + 1 < distances[r][c - 1]) {
				q.add(new Coordinate(r, c - 1));
				distances[r][c - 1] = distances[r][c] + 1;
			}
			
			// going right
			if (c + 1 < m && map[r][c + 1] != 'X' &&distances[r][c] + 1 < distances[r][c + 1]) {
				q.add(new Coordinate(r, c + 1));
				distances[r][c + 1] = distances[r][c] + 1;
			}
		}
		if (distances[end.row][end.col] != Integer.MAX_VALUE )
			System.out.println(distances[end.row][end.col] - 1);
		else
			System.out.println(-1);
		
	}
	
	public static class Coordinate {
		public int row;
		public int col;
		
		public Coordinate(int row, int col){
			this.row = row;
			this.col = col;
		}
	}


}
