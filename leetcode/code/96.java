public class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        return getNum(dp, n);
    }
    
    int getNum(int[] dp, int n) {
        
        if (dp[n] != 0) return dp[n];
        
        for (int i=0; i<=n-1; i++) {
            dp[n] += (getNum(dp, i)*getNum(dp, n-1-i));
        }
        
        return dp[n];
    }
}  