public class Solution {
    public boolean isValidSudoku(char[][] board) {
    
        boolean[][] used1 = new boolean[9][9];
        boolean[][] used2 = new boolean[9][9];
        boolean[][] used3 = new boolean[9][9];
        
        for (int i=0; i<board.length; i++) 
            for (int j=0; j<board[0].length; j++) {
                
                if (board[i][j] == '.') continue;
                
                int n = board[i][j]-'0'-1;
                int k = (i/3)*3+j/3;
                
                if (used1[i][n] || used2[j][n] || used3[k][n]) 
                    return false;
                    
                used1[i][n] = used2[j][n] = used3[k][n] = true;
            }
       
       return true;
    }
}