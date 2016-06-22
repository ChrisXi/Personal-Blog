public class Solution {
    public int numDistinct(String s, String t) {
        
        int h = t.length()+1, w = s.length()+1;
        int[][] dp = new int[2][w];
        
        for (int j=0; j<w; j++)
            dp[0][j] = 1;
        
        for (int i=1; i<h; i++) {
            int r1 = i%2;
            int r2 = 1-r1;
            for (int j=0; j<i; j++)
                dp[r1][j] = 0;
            for (int j=i; j<w; j++) 
                dp[r1][j] = (s.charAt(j-1)==t.charAt(i-1) ? dp[r1][j-1]+dp[r2][j-1]:dp[r1][j-1]);
        }
        
        return dp[(h-1)%2][w-1];
    }
}