public class Solution {
    public int climbStairs(int n) {
        
        if (n == 0) return 1;
        if (n == 1 || n == 2) 
            return n;
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        return climb(n, dp);
    }
    
    int climb(int n, int[] dp) {
        if (dp[n-1] != 0) return dp[n-1];
        dp[n-1] = climb(n-1, dp)+climb(n-2, dp);
        
        return dp[n-1];
    }
}