public class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        
        int h = coins.length+1;
        int w = amount+1;
        int[][] dp = new int[h][w];
        
        for (int i=0; i<h; i++) 
            dp[i][0] = -1;
            
        for (int j=1; j<w; j++)
            dp[0][j] = -1;
        
        for (int i=1; i<h; i++) {
            for (int j=1; j<w; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else if (coins[i-1] == j) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i][j-coins[i-1]] != -1) {
                        if (dp[i-1][j] != -1)
                            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                        else
                            dp[i][j] = dp[i][j-coins[i-1]]+1;
                    } else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[h-1][w-1];
    }
}