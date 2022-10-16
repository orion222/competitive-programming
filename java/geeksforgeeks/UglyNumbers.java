package geeksforgeeks;

import java.util.*;
public class UglyNumbers {
	
	public static void main(String[] args) {
		
		int[] nums = new int[150];
		
		int j = 0;
		int k = 0;
		int l = 0;
		nums[0] = 1;
		
		// store the first 5 ugly numbers
		for (int i = 1; i < 150; i++) {
			int a = nums[j] * 2;
			int b = nums[k] * 3;
			int c = nums[l] * 5;
			nums[i] = Math.min(Math.min(a , b), c);
			
			int u = nums[i];
			
			if (u % 30 == 0) {
				j++;
				k++;
				l++;
			}
			else if (u % 6 == 0) {
				j++;
				k++;
			}
			else if (u % 10 == 0) {
				j++;
				l++;
			}
			
			else if (u % 15 == 0) {
				k++;
				l++;
			}
			else if (u == a) j++;
			else if (u == b) k++;
			else l++;
		}
		
		for (int i: nums) System.out.println(i);
		
		
	}
}
