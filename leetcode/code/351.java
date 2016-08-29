public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        
        int[] visit = new int[10];
        int ans = 0;
        for (int i=m; i<=n; i++) {
            ans += search(i-1, skip, visit, 1)*4;
            ans += search(i-1, skip, visit, 2)*4;
            ans += search(i-1, skip, visit, 5);
        }
        
        return ans;
    }
    
    int search(int count, int[][] skip, int[] visit, int n) {
        if (count == 0) return 1;
        
        visit[n] = 1;
        int ans = 0;
        for (int i=1; i<=9; i++) {
            if (visit[i] == 0 && (skip[n][i] == 0 || visit[skip[n][i]] == 1)) 
                ans += search(count-1, skip, visit, i);
        }
        visit[n] = 0;
        return ans;
    }
}