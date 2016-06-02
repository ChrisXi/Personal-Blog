public class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int h = matrix.length;
        if (h == 0) 
            return 0;
        
        int w = matrix[0].length;
        int[][] dp = new int[h][w];
        
        for(int r=0; r<h; r++) 
            dp[r][0] = matrix[r][0]-'0';
        for(int c=0; c<w; c++) 
            dp[0][c] = matrix[0][c]-'0';    
        
        for(int r=1; r<h; r++) {
            for(int c=1; c<w; c++) {
                if(matrix[r][c] == '0') {
                    dp[r][c] = 0;
                } else {
                    int l1 = dp[r-1][c];
                    int l2 = dp[r][c-1];
                    
                    if(l1 == l2) {
                        dp[r][c] = matrix[r-l1][c-l2]=='1' ? l1+1:l1;
                    } else {
                        dp[r][c] = Math.min(l1, l2)+1;
                    }
                    
                }
            }
        }
        
        int max = 0;
        for(int r=0; r<h; r++) {
            for(int c=0; c<w; c++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        
        return max*max;
        
    }
}