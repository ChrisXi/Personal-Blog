public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int count = 0;
        int up=0,  right=n-1, bottom=n-1,left=0;
        int i=0, j=0;
        int r=0, c=1;
        while (count++ < n*n) {
            ans[i][j] = count;
            
            if (right < j+c) {r = 1; c = 0; up ++;}
            else if (bottom < i+r) {r = 0; c = -1; right --;}
            else if (j+c < left) {r = -1; c = 0; bottom --;}
            else if (i+r < up) {r = 0; c = 1; left ++;}
            
            i += r;
            j += c;
        }
        
        return ans;
    }
}