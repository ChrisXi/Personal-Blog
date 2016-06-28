public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int h = dungeon.length, w = dungeon[0].length;
        
        int[][] dp = new int[h][w];
        dp[h-1][w-1] = Math.max(1-dungeon[h-1][w-1], 1);
        
        for (int i=h-2; i>=0; i--)
            dp[i][w-1] = Math.max(dp[i+1][w-1] - dungeon[i][w-1], 1);
        for (int j=w-2; j>=0; j--)
            dp[h-1][j] = Math.max(dp[h-1][j+1] - dungeon[h-1][j], 1);
          
        for (int i=h-2; i>=0; i--) {
            for (int j=w-2; j>=0; j--) {
                int down  = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);  
            }
        }  
        
        return dp[0][0];
    }
}