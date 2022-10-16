package algos;

import java.util.Arrays;

class inputForMST {
  
  public static class Edge implements Comparable<Edge> {
      //instance variable
      public int bv;
      public int ev;
      public int cost;
      public Edge(int bv, int ev, int cost) {
        this.bv = bv;
        this.ev = ev;
        this.cost = cost;  
      }
    
    
      //a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
    
      public int compareTo(Edge o) {
        //the current edge-- this
        //to compare the input edge which is o
        if (this.ev>o.ev) {
          return 1;
        } else if (this.ev<o.ev) {
          return -1;
        } else {
          return 0;
        }
      }
  }
  public static void main(String[] args) {
     //What is Kruskal's algorithm
    
     //minimum spanning tree
    
     //Kruskal's is the algorithm we learn starting from today
     //it is graph theory algorithm
     //make sure all the vertex directly or indirectly connected together with minimum cost
    
    
     //In order to do this, we need save the graph into oneD array
     //each element inside oneD array is one connection (Edge)
     //We sort the edge based on cost
     //then choose the edge one by one from sorted array
     //when we add the edge into minimum spanning tree
     //if the edge form a loop then discard it
     //otherwise keep the edge into the tree
    
    
    
     //Step 1:
     //Store the graph into oneD array
    
     //3 data represent one edge
     //beginVertex, endVertex, cost
    
     Edge[] edges = new Edge[6];
     edges[0] = new Edge(0,1,4);
     edges[1] = new Edge(0,3,9);
     edges[2] = new Edge(2,3,8);
     edges[3] = new Edge(1,3,7);
     edges[4] = new Edge(1,2,5);
     edges[5] = new Edge(0,2,6);
    
     Arrays.sort(edges);
    
     for (Edge e: edges) {
       System.out.println(e.bv+" "+e.ev+" "+e.cost);
     }
    
    
  }
}
