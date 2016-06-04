public class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            
            int p=1;
            while (i >= p*p) {
                min = Math.min(min, dp[i-p*p]+1);
                p++;
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}