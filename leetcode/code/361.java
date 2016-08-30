public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
        int ans = 0;
        if (grid.length == 0) return 0;
        
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                
                if (c == 0 || grid[r][c-1] == 'W') {
                    rows[r] = 0;
                    int i = c;
                    while (i < grid[0].length && grid[r][i] != 'W') {
                        rows[r] += (grid[r][i]=='E' ? 1:0);
                        i ++;
                    }
                }
                
                if (r == 0 || grid[r-1][c] == 'W') {
                    cols[c] = 0;
                    int j = r;
                    while (j < grid.length && grid[j][c] != 'W') {
                        cols[c] += (grid[j][c]=='E' ? 1:0);
                        j ++;
                    }
                }
                
                ans = grid[r][c]=='0' ? Math.max(ans, rows[r]+cols[c]):ans;
            }
        }
        return ans;
    }
}