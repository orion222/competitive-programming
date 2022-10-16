package dmoj;

import java.util.*;

public class disjointSetTest {

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
			if (this.price > f.price) 
				return 1;
	        
			else if (this.price < f.price) 
	        	return -1;
	         
			else 
				return 0;
	        
	    }
		
		public String toString(edge e) {
			return e.bv + " " + e.ev + " " + e.price;
		}
		
	}
	public static int[] parents;
	public static int find(int v) {
		// base case: find the root
		if (parents[v] == -1) {
			return v;
		}
		
		parents[v] = find(parents[v]);  
		System.out.println();
		
		return parents[v];
	}
	
	
	public static void union(int bvroot, int evroot) {
		parents[bvroot] = evroot;  
	}
	
	public static void main(String[] args) {
		//
		
		Scanner s = new Scanner(System.in);
		
		int vertices = s.nextInt(); int edges = s.nextInt();
		edge[] graph = new edge[6];
		
		parents = new int[vertices];
		Arrays.fill(parents,  -1);

		
		LinkedList<Integer> edgeNumbers = new LinkedList<Integer>();
     	for (int i = 1; i <= edges; i++) {  
     		int bv = s.nextInt() - 1; int ev = s.nextInt() - 1;
     		int bvroot = find(bv);
     		int evroot = find(ev);
     		if (evroot != bvroot) {
     			union(bvroot, evroot);
     			edgeNumbers.add(i);
     			if (edgeNumbers.size() == vertices - 1)
     				break;
     		}
     		
        }
	    
     	
     	if (edgeNumbers.size() == vertices - 1) {
     		for (int e: edgeNumbers) {
         		System.out.println(e);
         	}
     	}
     	else {
     		System.out.println("Disconnected Graph");
     		
     	}
     	
		
	}

}	
