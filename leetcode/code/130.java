public class Solution {
    public void solve(char[][] board) {
        
        int h = board.length;
        if (h == 0) return;
        
        int w = board[0].length;
        int[][] visited = new int[h][w];
        
        for (int i=1; i<h-1; i++) {
            if (board[i][0] == 'O') check(board, visited, i, 1);    
            if (board[i][w-1] == 'O') check(board, visited, i, w-2);
        }
        
        for (int j=1; j<w-1; j++) {
            if (board[0][j] == 'O') check(board, visited, 1, j);
            if (board[h-1][j] == 'O') check(board, visited, h-2, j);
        }
        
        for (int i=1; i<h-1; i++) 
            for (int j=1; j<w-1; j++) {
                if (board[i][j]=='E')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
                
    }
    
    void check(char[][] board, int[][] visited, int i, int j) {
        
        int h = board.length, w = board[0].length;
        
        if (1<=i && i<h-1 && 1<=j && j<w-1 && visited[i][j] == 0 && board[i][j] == 'O') {
            board[i][j] = 'E';
            visited[i][j] = 1;
            check(board, visited, i-1, j);
            check(board, visited, i+1, j);
            check(board, visited, i, j-1);
            check(board, visited, i, j+1);
        }
    }
}