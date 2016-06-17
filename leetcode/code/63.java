public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
       int h = obstacleGrid.length, w = obstacleGrid[0].length;
    
       int[][] dp = new int[2][w];
       
       dp[0][0] = 1-obstacleGrid[0][0];
       for (int j=1; j<w; j++) 
           dp[0][j] = (obstacleGrid[0][j]==1 ? 0:dp[0][j-1]);
       
       for (int i=1; i<h; i++) {
           
           int r1 = i%2;
           int r2 = 1-r1;
           dp[r1][0] = (obstacleGrid[i][0]==1 ? 0:dp[r2][0]);
           for (int j=1; j<w; j++) 
               dp[r1][j] = (obstacleGrid[i][j]==1 ? 0:(dp[r2][j]+dp[r1][j-1]));
       }
       
       return dp[(h-1)%2][w-1];
       
    }
}