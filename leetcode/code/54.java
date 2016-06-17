public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0) return ans;
        
        int h = matrix.length, w = matrix[0].length;
        
        int r = 0, c = 1;
        
        int count = 0;
        int i=0, j=0;
        int up=0, right=w-1, bottom=h-1, left=0; //border
        while (count++ < h*w) {
            ans.add(matrix[i][j]);
            
            if (right < j+c) {r = 1; c = 0; up ++;} 
            else if (bottom < i+r) {r = 0; c = -1; right --;}
            else if (j+c < left) {r = -1; c = 0; bottom --;} 
            else if (i+r < up) {r = 0; c = 1; left ++;}
            
            i += r;
            j += c;
        }
        
        return ans;
    }
}