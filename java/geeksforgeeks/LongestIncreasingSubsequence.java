package geeksforgeeks;

import java.util.*;
public class LongestIncreasingSubsequence {
	
	public static int[] nums;
	public static int[] memo;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// number of terms
		int n = sc.nextInt();
		
		nums = new int[n + 1];
		memo = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}
		
		System.out.println(LIS(n));

	}
	

	public static int LIS (int a) {
		
		if (nums[a] == nums[0]) return 1;
		else if (memo[a] > 1) return memo[a];
		for (int i = a - 1; i >= 0; i--) {
			if (nums[i] < nums[a]) {
				memo[a] = Math.max(LIS(i) + 1, memo[a]);
			}
		}
		
		return memo[a];
	}
	
	public static void forLoopLIS() {
		 int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};

         //create memo[] array with the same size as A
         //fill memo[] array value 1
   
         //from i=1  to A.length  you start to fill memo array

         //check all the value from 0 to i-1 if smaller than A[i]
         // if yes you update memo array with the Math.max memo[j]+1
   
          int[] memo = new int[A.length];
          Arrays.fill(memo,1);

         for (int i=1; i<A.length; i++) {
             for (int j=0; j<i; j++) {
                if (A[j]<A[i]) {
                 memo[i] = Math.max(memo[i], memo[j]+1);
                }
              }
          }

         //for loop from memo to find out the biggest one

         int max = 1;

         for (int n:memo) {
           if (n>max) {
             max = n;
           }
         }
         System.out.println(max);
	}

}
