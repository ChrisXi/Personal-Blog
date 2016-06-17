public class Solution {
    public int minPathSum(int[][] grid) {
        
        int h = grid.length, w= grid[0].length;
        int[][] dp = new int[2][w];
        
        for (int j=0; j<w; j++)
            dp[0][j] = (j==0 ? grid[0][j]:grid[0][j]+dp[0][j-1]);
        
        for (int i=1; i<h; i++) {
            int r1 = i%2;
            int r2 = 1-r1;
            
            for (int j=0; j<w; j++) 
                dp[r1][j] = (j==0 ? grid[i][j]+dp[r2][j]:grid[i][j]+Math.min(dp[r1][j-1],dp[r2][j]));
        }
        
        return dp[(h-1)%2][w-1];
    }
}