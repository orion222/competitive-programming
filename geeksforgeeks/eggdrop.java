package geeksforgeeks;

class eggdrop 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
	public static int n = 3;
	public static int k = 4;
	public static int[][] memo = new int[n + 1][k + 1];
    public static void main(String[] args) {
    	System.out.println(eggDrop(3, 4));
    	System.out.println(memo[3][4]);
    	
        for (int[] i: memo){
            for (int x: i){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    
    
    static int eggDrop(int n, int k) 
	{    
        for (int i = 0; i <= n; i++){
            for (int x = 0; x <= k; x++){
                if (x == 1 || x == 0 || i == 1){
                    return k;
        	    }
        	    if (i == 0){
        	        return 0;
        	    }
        	    if (memo[i][x] != 0) return memo[i][x];
        	    
        	    memo[i][x] = Math.max(memo[i][k - x], memo[i - 1][x - 1]) + 1;
            }
        }

        
        return memo[n][k];
	}
}