public class Solution {
    public void gameOfLife(int[][] board) {
        
        //0:dead 1:live 2:from dead to live 3:from live to dead
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                
                int count = 0;
                for (int i=r-1; i<=r+1; i++) {
                    for (int j=c-1; j<=c+1; j++) {
                        if(0<=i && i<board.length && 0<=j && j<board[0].length && !(i==r && j==c)) {
                            count = (board[i][j]==1 || board[i][j]==3) ? count+1:count;
                        }
                    }
                }
                
                if (board[r][c] == 1) {
                    board[r][c] = (count < 2 || count > 3) ? 3:1;
                } else if (board[r][c] == 0) {
                    board[r][c] = (count==3 ? 2:0);
                }
            }
        }
        
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (board[r][c] == 2) board[r][c] = 1;
                else if (board[r][c] == 3) board[r][c] = 0;
            }
        }
    }
}