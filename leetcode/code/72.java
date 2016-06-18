public class Solution {
  
    public int minDistance(String word1, String word2) {
        
        int h = word1.length(), w = word2.length();
        
        int[][] dp = new int[2][w+1];
        for (int j=0; j<=w; j++) 
            dp[0][j] = j;
        
        for (int i=1; i<=h; i++) {
            
            int r1 = i%2;
            int r2 = 1-r1;
            dp[r1][0] = i;
            for (int j=1; j<=w; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[r1][j] = dp[r2][j-1];
                else 
                    dp[r1][j] = Math.min(dp[r2][j-1], Math.min(dp[r2][j], dp[r1][j-1]))+1;
            }
        }
        
        return dp[h%2][w];
    }
}