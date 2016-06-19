public class Solution {
    public boolean exist(char[][] board, String word) {
        
        if (word.length() == 0) 
            return true;
        
        int h = board.length, w = board[0].length;
        
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (word.charAt(0) == board[i][j]) {
                    int[][] visited = new int[h][w];
                    visited[i][j] = 1;
                    boolean ans = search(i, j-1, h, w, board, visited, word.substring(1)) ||
                                  search(i-1, j, h, w, board, visited, word.substring(1)) ||
                                  search(i+1, j, h, w, board, visited, word.substring(1)) ||
                                  search(i, j+1, h, w, board, visited, word.substring(1));
                    if (ans) 
                        return true;
                }
            }
        }
        
        return false;
    }
    
    boolean search (int r, int c, int h, int w, char[][] board, int[][] visited, String word) {
        
        if (word.length() == 0)
            return true;
            
        if (r<0 || r>=h || c<0 || c>=w || visited[r][c] == 1 || word.charAt(0) != board[r][c]) 
            return false;
        
        visited[r][c] = 1;
        boolean ans = search(r, c-1, h, w, board, visited, word.substring(1)) ||
                      search(r-1, c, h, w, board, visited, word.substring(1)) ||
                      search(r+1, c, h, w, board, visited, word.substring(1)) ||
                      search(r, c+1, h, w, board, visited, word.substring(1));
        visited[r][c] = 0;
        
        return ans;
  
        
    }
}