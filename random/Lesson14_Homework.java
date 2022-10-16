package random;

import java.io.*;
import java.util.*;
public class Lesson14_Homework {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		// to execute task 1, just type task1(); below
		// same thing for task 2 and 3: task2(); task3();

		
	}
	
	public static void task1() {
		
		char[][] map = new char[3][6];
		
		for (int i = 0; i < map.length; i++) {
			map[i] = sc.nextLine().toCharArray();
			
			// sc.nextLine() ==> "apple"
			// sc.nextLine().toCharArray() ==> ['a', 'p', 'p', 'l', 'e']
			
		}
		
		// map: [ [list of characters], [list of characters], [list of characters]]
		
		for (int i = 0; i < map.length; i++) {
			for (int x = 0; x < map[i].length; x++) {
				System.out.print(map[i][x] + " ");
				
			}
			System.out.println();
		}
	}
	
	public static void task2() {
		char[][] map = new char[6][7];
		
		Coordinate S = new Coordinate(-1, -1);
		for (int i = 0; i < map.length; i++) {
			map[i] = sc.nextLine().toCharArray();
			
			for (int x = 0; x < map[i].length; x++) {
				if (map[i][x] == 'S') {
					S = new Coordinate(i, x);
				}
			}
		}
		
		System.out.println(S.row + " " + S.col);

	}
	
	public static void task3() {
		char[][] map = new char[6][7];
		
		Coordinate S = new Coordinate(-1, -1);
		for (int i = 0; i < map.length; i++) {
			map[i] = sc.nextLine().toCharArray();
			
			for (int x = 0; x < map[i].length; x++) {
				if (map[i][x] == 'S') {
					S = new Coordinate(i, x);
				}
			}
		}
		
		int[][] distances = new int[map.length][map[0].length];
		for (int i = 0; i < distances.length; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		}
		distances[S.row][S.col] = 0;
		
		LinkedList<Coordinate> q = new LinkedList<Coordinate>();
		q.add(S);
		
		int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!q.isEmpty()) {
			Coordinate cur = q.poll();
			
			// crow = current row, ccol = current col
			int crow = cur.row;
			int ccol = cur.col;
			if (cur.row == 0 && cur.col == 0) {
				System.out.println(distances[0][0]);
				break;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int[] direction = directions[i];
				
				
				
				// nrow is new row, ncol is ncol
				// directions[0] stores change to the row
				// directions[1] stores change to the col
				int nrow = crow + direction[0];
				int ncol = ccol + direction[1];
				
				if (0 <= nrow && nrow < map.length && 0 <= ncol && ncol < map[0].length &&
						distances[crow][ccol] + 1 < distances[nrow][ncol] && map[nrow][ncol] != '#') {
					q.add(new Coordinate(nrow, ncol));
					distances[nrow][ncol] = distances[crow][ccol] + 1;
				}

			}
		}
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
