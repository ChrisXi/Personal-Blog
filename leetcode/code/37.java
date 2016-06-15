public class Solution {
    public void solveSudoku(char[][] board) {
    
        boolean[][] used1 = new boolean[9][9];
        boolean[][] used2 = new boolean[9][9];
        boolean[][] used3 = new boolean[9][9];
        
        for (int i=0; i<board.length; i++) 
            for (int j=0; j<board.length; j++) {
                if (board[i][j] == '.') continue;
                
                int n = board[i][j]-'1';
                int k = (i/3)*3+j/3;
                used1[i][n] = used2[j][n] = used3[k][n] = true;
            }
                
        solve(board, used1, used2, used3);
    }
    
    boolean solve(char[][] board, boolean[][] used1, boolean[][] used2, boolean[][] used3) {
        
        for (int i=0; i<board.length; i++) 
            for (int j=0; j<board[0].length; j++) {
                
                if (board[i][j] != '.') continue;
                
                for (int n=0; n<9; n++) {
                    
                    int k = (i/3)*3+j/3;
                    if (! (used1[i][n] || used2[j][n] || used3[k][n])) {
                        
                        used1[i][n] = used2[j][n] = used3[k][n] = true;
                        board[i][j] = (char)('1'+n);
                        
                        if(solve(board, used1, used2, used3))
                            return true;
                            
                        board[i][j] = '.';
                        used1[i][n] = used2[j][n] = used3[k][n] = false;
                    }
                }
                return false;
            }
            
        return true;
    }
}