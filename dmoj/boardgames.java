package dmoj;

// https://dmoj.ca/problem/boardgames
import java.io.*;
import java.util.*;
public class boardgames {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] distances = new int[(int)1e7 + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[n] = 0;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == m) {
				System.out.println(distances[cur]);
				break;
			}
			
			if (3 * cur <= 1e7 && distances[cur] + 1 < distances[3 * cur]) {
				distances[3 * cur] = distances[cur] + 1;
				q.add(3 * cur);
			}
			
			if (cur - 1 > 0 && distances[cur] + 1 < distances[cur - 1]) {
				distances[cur - 1] = distances[cur] + 1;
				q.add(cur - 1);
			}
			if (cur - 3 > 0 && distances[cur] + 1 < distances[cur - 3]) {
				distances[cur - 3] = distances[cur] + 1;
				q.add(cur - 3);
			}
			
			if (cur % 2 == 0 && distances[cur] + 1 < distances[cur / 2]) {
				distances[cur / 2] = distances[cur] + 1;
				q.add(cur / 2);
			}
			
		}
		
		
		
		
	}

}
