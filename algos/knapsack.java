package algos;


public class knapsack {
    public int bounded(int[] v, int[] w, int[] k, int C) {
        int n = v.length;
        int[][] dp = new int[n+1][C+1];   //row is item number col is weight
        for (int row=1; row<=n; row++) {
            for (int col=1; col<=C; col++) {
                for (int copies=0; copies<=k[row-1]; copies++) {
                    int totalWeight = w[row-1]*copies;
                    if (col<totalWeight) break;
                    int totalValue = v[row-1]*copies;
                    dp[row][col] = Math.max(dp[row][col], dp[row-1][col-totalWeight]+totalValue);
                }
            }
        }
        return dp[n][C];
    }




    public int unbounded(int[] v, int[] w, int C) {
        int n = v.length;
        int[] dp = new int[C+1];
        for (int c=1; c<=C; c++) {    //c is column     represent the total capacity
            for (int i=0; i<n; i++) {
                if (c<w[i]) continue;
                dp[c] = Math.max(dp[c], dp[c-w[i]]+v[i]);
            }
        }
        return dp[C];
    }
    public static void main(String[] args) {

    }


}
