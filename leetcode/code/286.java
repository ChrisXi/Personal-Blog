public class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        for (int r=0; r<rooms.length; r++) {
            for (int c=0; c<rooms[0].length; c++) {
                if (rooms[r][c] == 0) {
                    search(rooms, r+1, c, 1);
                    search(rooms, r-1, c, 1);
                    search(rooms, r, c+1, 1);
                    search(rooms, r, c-1, 1);
                }
            }
        }
    }
    
    void search(int[][] rooms, int r, int c, int step) {
        if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length ||
            rooms[r][c] == 0 || rooms[r][c] == -1 || rooms[r][c] <= step)
            return;
        
        rooms[r][c] = step;
        search(rooms, r+1, c, step+1);
        search(rooms, r-1, c, step+1);
        search(rooms, r, c+1, step+1);
        search(rooms, r, c-1, step+1);
    }
}