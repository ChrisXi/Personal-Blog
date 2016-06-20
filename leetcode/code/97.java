public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length()+s2.length() != s3.length())
            return false;
        
        int h = s1.length()+1, w = s2.length()+1;
        int[][] dp = new int[h][w];
        
        dp[0][0] = 1;
        
        for (int i=1; i<h; i++)
            dp[i][0] = (s3.charAt(i-1)==s1.charAt(i-1) && dp[i-1][0]==1 ? 1:0);
        for (int j=1; j<w; j++) 
            dp[0][j] = (s3.charAt(j-1)==s2.charAt(j-1) && dp[0][j-1]==1 ? 1:0);
        
        for (int i=1; i<h; i++) {
            for (int j=1; j<w; j++) {
                
                char c1=s1.charAt(i-1), c2=s2.charAt(j-1),
                     c3=s3.charAt(i+j-1);
                
                if ((c1==c3 && dp[i-1][j]==1) || (c2==c3 && dp[i][j-1]==1))
                    dp[i][j] = 1;
            }
        }
            
        return dp[h-1][w-1]==1;  
    }
}  