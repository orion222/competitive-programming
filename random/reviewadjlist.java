package random;

import java.io.*;
import java.util.*;
public class reviewadjlist {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer>[] adjList = new ArrayList[6];
		
		for (int i = 0; i < 6; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		adjList[0].add(2);
		adjList[0].add(4);
		adjList[0].add(5);
		
		adjList[1].add(4);
		adjList[1].add(5);
		
		adjList[2].add(0);
		adjList[2].add(3);
		adjList[2].add(4);
		
		adjList[3].add(2);
		
		adjList[4].add(0);
		adjList[4].add(1);
		adjList[4].add(2);
		adjList[4].add(5);
		
		adjList[5].add(0);
		adjList[5].add(4);
		adjList[5].add(1);
		
		
		int[] distances = new int[6];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < adjList[cur].size(); i++) {
				
				// adjList[cur].get(i)
				
				int neighbor = adjList[cur].get(i);
				if (distances[cur] + 1 < distances[neighbor]) {
					q.add(neighbor);
					distances[neighbor] = distances[cur] + 1;
				}
				
			}
		}
		
		System.out.println(distances[3]);


		


		
		

	}

}
