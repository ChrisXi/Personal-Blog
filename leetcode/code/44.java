public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        
        char[][] dp = new char[len1+1][len2+1];
        dp[0][0] = '1';
        
        for (int j=1; j<=len2; j++) {
            if (p.charAt(j-1) == '*') dp[0][j] = '1';
            else break;
        }
        
        for (int i=1; i<=len1; i++) 
            for (int j=1; j<=len2; j++) {
                if (p.charAt(j-1) == '*') {
                    if (dp[i][j-1]=='1' || dp[i-1][j-1]=='1' || dp[i-1][j]=='1')
                        dp[i][j] = '1';
                } else {
                    if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                        dp[i][j] = dp[i-1][j-1];
                }
            }
            
        return dp[len1][len2] == '1';
    }
}