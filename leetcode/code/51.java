public class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        if (n <= 0) return ans;
        
        boolean[] used2 = new boolean[n];
        boolean[] used3 = new boolean[2*n-1];
        boolean[] used4 = new boolean[2*n-1];
        
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++)
            Arrays.fill(board[i], '.');
        
        check(ans, board, 0, -1, -1, n, used2, used3, used4);
        return ans;
    }
    
    void check(List<List<String>> ans, char[][] board, int s, int sr, int sc, int n, boolean[] used2, boolean[] used3, boolean[] used4) {
        
        for (int i=s; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                
                if (board[i][j] == 'Q' || i*board.length+j <= sr*board.length+sc) continue;
                
                if (!(used2[j] || used3[i+j] || used4[i+board.length-1-j])) {
                    
                    used2[j] = used3[i+j] = used4[i+board.length-1-j] = true;    
                    board[i][j] = 'Q';

                    if (n-1 == 0) {
                        List<String> lst = new ArrayList<String>();
                        for (int l=0; l<board.length; l++) {
                            String str = String.valueOf(board[l]);
                            lst.add(str);   
                        }
                        ans.add(lst);
                    } else {
                        check(ans, board, i+1, i, j, n-1, used2, used3, used4);   
                    }
                        
                    used2[j] = used3[i+j] = used4[i+board.length-1-j] = false;    
                    board[i][j] = '.';  
                }
            }
        }
    }
}