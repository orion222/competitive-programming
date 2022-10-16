package algos;

import java.io.*;
import java.util.*;

// input from https://dmoj.ca/problem/ccc06j4
class dependencyArrays {
	// 1,7
	// 1,4
	// 2,1
	// 3,4
	// 3,5
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
          //dep array saves the numbser dependencies
          int[] dep = new int[] {1, 0, 0, 2, 1, 0, 1};
          
          //boolean 2D array to set dependency
          // 
          boolean[][] dep2 = new boolean[7][7];
          
          // task 6 depends on task 0
          dep2[0][6] = true;
          
          // task 3 depends on task 0
          dep2[0][3] = true;
          dep2[1][0] = true;
          dep2[2][3] = true;
          dep2[2][4] = true;

          while (true) {
            int bv = sc.nextInt()-1;
            int ev = sc.nextInt()-1;
            if (bv == -1 && ev == -1) {
              break;
            }
            
            dep[ev]++;
            dep2[bv][ev] = true;
          }


          //using for loop to find out the dep value which is 0 
          //save that index into LinkedList and set dep value to -1
          //update dep array based on dep2

    }
}

