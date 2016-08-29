public class TicTacToe {

    /** Initialize your data structure here. */
    int[][] rows;
    int[][] cols;
    int[] diags;
    int[] antiDiags;
    int ans, len;
    public TicTacToe(int n) {
        rows = new int[2][n];
        cols = new int[2][n];
        diags = new int[2];
        antiDiags = new int[2];
        ans = 0;
        len = n;
        for (int i=1; i<=n ;i++)
            ans += i; 
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[player-1][row] += (col+1);
        cols[player-1][col] += (row+1);
        if (row == 1 && col == 1) {
            diags[player-1] += (row+1);
            antiDiags[player-1] += (row+1);
        } else if (row == col) {
            diags[player-1] += (row+1);
        } else if (row+col == len-1) {
            antiDiags[player-1] += (row+1);
        }
        
        if (rows[player-1][row] == ans || cols[player-1][col] == ans|| 
            diags[player-1] == ans || antiDiags[player-1] == ans)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */