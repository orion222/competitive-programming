package algos;

public class fibonacci {
	
	public static long[] memo = new long[101]; // fib(n) n <= 100
	
	public static void main(String[] args) {
		
		System.out.println(optimizedFib(100));
		
		System.out.println(naiveFib(100));
	}
	
	
	public static long naiveFib(int n) {
		if (n == 1 || n == 2) return 1;
		return naiveFib(n - 1) + naiveFib(n - 2);
	}
	
	public static long optimizedFib(int n) {
		
		if (n == 1 || n == 2) return 1;
		else if (memo[n] != 0) return memo[n];
		
		memo[n] = optimizedFib(n - 1) + optimizedFib(n - 2);
		return memo[n];
		
	}

}
