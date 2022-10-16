package algos;

import java.util.*;
public class dijkstra {
	
	public static void main(String[] args) {
		
		int v = 4; int e = 5;
		ArrayList<Pair>[] adjList = new ArrayList[v];
		for (int i = 0; i < v; i++) adjList[i] = new ArrayList<Pair>();
		adjList[0].add(new Pair(1, 6));
		adjList[0].add(new Pair(3, 4));
		adjList[0].add(new Pair(2, 5));
		adjList[1].add(new Pair(0, 6));
		adjList[1].add(new Pair(2, 7));
		adjList[2].add(new Pair(3, 2));
		adjList[2].add(new Pair(0, 5));
		adjList[2].add(new Pair(1, 7));
		adjList[3].add(new Pair(2, 2));
		adjList[3].add(new Pair(0, 4));

		int[] distances = new int[v];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0; // if we start at 0
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0, 0));
		
		while (!pq.isEmpty()) {
			int vcur = pq.peek().ev;
			int vcost = pq.peek().cost;
			pq.poll();
			if (vcost > distances[vcur]) continue; // saves time
			for (Pair i: adjList[vcur]) {
				if (distances[i.ev] > distances[vcur] + i.cost) {
					distances[i.ev] = distances[vcur] + i.cost;
					pq.add(new Pair(i.ev, distances[i.ev]));
				}
			}
		}
		
		System.out.println(distances[3]);
	}
	
	public static class Pair implements Comparable<Pair>{
		public int ev;
		public int cost;
		
		public Pair(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
		
		public int compareTo(Pair o) {
			return Integer.compare(o.cost, this.cost);
		}
	}
}
