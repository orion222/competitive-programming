package algos;

import java.util.Scanner;
import java.util.Arrays;

public class MST {
	
	static Scanner s = new Scanner(System.in);

	public static class edge implements Comparable<edge>{
		
		public int bv;
		public int ev;
		public int price;
		
		public edge(int bv, int ev, int price) {
			this.bv = bv;
			this.ev = ev;
			this.price = price;
		}
		
		public int compareTo(edge f) {
	        //the current edge-- this
	        //to compare the input edge which is f
			if (this.price > f.price) 
				return -1;
	        
			else if (this.price < f.price) 
	        	return 1;
	         
			else 
				return 0;
	        
	    }
		
		public String toString(edge e) {
			return e.bv + " " + e.ev + " " + e.price;
		}
		
	}
	public static int[] parents;
	
	// create a function to find out the root of a vertex
	// disjoint set
	// union and find function
	// use find function to find out the root
	// use union function to connect to vertex
	
	public static int find(int v) {
		// base case: find the root
		if (parents[v] == -1) {
			return v;
		}
		
		parents[v] = find(parents[v]);  // finding the ROOT of the given bv and ev
		
		return parents[v];
	}
	
	
	// connects 2 sets together
	public static void union(int bvroot, int evroot) {
		parents[bvroot] = evroot;  
	}
	
	public static void main(String[] args) {
		//
		
		
		// nodes then edges	
		int v = s.nextInt(); int u = s.nextInt();
		edge[] graph = new edge[u];
		
		for (int i = 0; i < u; i++) {
			int bv = s.nextInt();
			int ev = s.nextInt();
			int cost = s.nextInt();
			graph[i] = new edge(bv, ev, cost);
		}
		
		Arrays.sort(graph);
		
		/* 
		 * 0, 3, 7
		 * 3, 2, 6
		 * 2, 4, 8
		 * 1, 2, 5
		 * 0, 1, 4
		 * 3, 4, 9
		 */
		 
		
		// create a parents array that stores each node's parent
		// each index is the node
		parents = new int[v + 1];
		Arrays.fill(parents,  -1);
		
		// read edges one by one 
		// if bv's root is not equal to ev's root (find it)
		// then you keep it by using union
		// otherwise, you discard it
		
		edge[] mst = new edge[v - 1];
		int count = 0;
     	for (edge e: graph) {  // remember that graph is SORTED, so the edges will come in at increasing weights
	        int bvroot = find(e.bv);  	// finding where each of these nodes STEM from
	        int evroot = find(e.ev);
	        if (bvroot != evroot) {	// if the root of BV != root of EV
	        	union(bvroot, evroot);
	        	mst[count] = e;
	        	count++;
	        	if (count == v - 1)  	// when we have the minimum amount of edges (v - 1), 
	        		break;  		   	// we break because we want the minimum to be efficient
	         
	        }
	    }
     	
     	for (edge e: mst) {
     		System.out.println(e.bv + " " + e.ev + " " + e.price);
     	}
		
		
	}

}	
