public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0)
            return false;
        
        return search(matrix, target, 0, 0, matrix[0].length-1, matrix.length-1);
    }
    
    boolean search(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        
        if(x1<0 || y1<0 || x2>=matrix[0].length || y2>= matrix.length || x1>x2 || y1>y2)
            return false;
        
        if(x1 == x2 && y1 == y2) 
            return matrix[y1][x1]==target;
        
        int xm = x1+((x2-x1)>>1);
        int ym = y1+((y2-y1)>>1);
        int n = matrix[ym][xm];
        
        if (n == target) {
            return true;
        } else if (n < target) {
            //check bottom right
            boolean br = search(matrix, target, xm+1, ym+1, x2, y2);
            //check bottom left
            boolean bl = search(matrix, target, x1, ym+1, xm, y2);
            //check top right
            boolean tr = search(matrix, target, xm+1, y1, x2, ym);
            
            return br || bl || tr;
        } else {
            //check top left
            boolean tl = search(matrix, target, x1, y1, xm-1, ym-1);
            //check bottom left
            boolean bl = search(matrix, target, x1, ym, xm-1, y2);
            //check top right
            boolean tr = search(matrix, target, xm, y1, x2, ym-1);
            
            return tl || bl || tr;
        }
    }
}