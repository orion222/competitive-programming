package algos;

public class nChoosek {
	
	public static int[][] memo = new int[101][101];
	public static void main(String[] args) {
		
	}
	
	
	// split n into smaller and smaller groups and sum up the unique
	// subsets 
	public static int choose(int n, int k) {
		
		// if you only choose 1, there are n things to choose so there
		// are n ways to choose 1 from n objects
		if (k == 1) return n;
		
		// if n == k, you have to choose all of them since you need to pick
		// n things, so there is only one way to do that
		if (n == k) return 1;
		
		// if we have not already calculated the value for choose(n, k), we will add it to the array
	
		if (memo[n][k] == 0) 
			memo[n][k] = choose(n - 1, k) + choose(n - 1, k - 1);
		
		// otherwise, return the pre-computed value
		return memo[n][k];
		
	}
	
	

}
