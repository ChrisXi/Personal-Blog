public class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[2][n];
        
        for (int j=0; j<n; j++)
            dp[0][j] = 1;
        
        for (int i=1; i<m; i++) {
            int r1 = i%2;
            int r2 = 1-r1;
            
            for (int j=0; j<n; j++) 
                dp[r1][j] = j==0 ? 1:dp[r1][j-1]+dp[r2][j];
        }
        
        return dp[(m-1)%2][n-1];
        
    }
}