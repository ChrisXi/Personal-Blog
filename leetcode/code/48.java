public class Solution {
    public void rotate(int[][] matrix) {
        
        int len = matrix.length;
        if (len == 0) return;
        
        for (int i=0; i<len/2; i++) {
            
            int loop = len-2*i-1;
            for (int j=0; j<loop; j++) {
                int r=i, c=i+j;
                int temp = matrix[r][c];
                matrix[r][c] = matrix[len-1-c][r];
                matrix[len-1-c][r] = matrix[len-1-r][len-1-c];
                matrix[len-1-r][len-1-c] = matrix[c][len-1-r];
                matrix[c][len-1-r] = temp;
            }
        }
        
    }
}