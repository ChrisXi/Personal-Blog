public class Solution {
    public void setZeroes(int[][] matrix) {
        
        int h=matrix.length, w=matrix[0].length;
        int first = 0;
        
        for (int i=0; i<h; i++) 
            for (int j=0; j<w; j++) {
                
                if (matrix[i][j] == 0)  {
                    if ((i==0 || j==0) && matrix[0][0]!=0) {
                        if (i==0) 
                            first = 2;
                        else 
                            first = (first==2 ? 0:3);
                            matrix[0][0] = (first==0 ? 0:matrix[0][0]);
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;    
                    }
                }
            }
        
        for (int i=h-1; i>=0; i--) 
            for (int j=w-1; j>=0; j--) 
                if (matrix[0][j] == 0 || matrix[i][0] == 0 || 
                   ((first == 2 && i == 0) || (first == 3 && j == 0)))
                    matrix[i][j] = 0;
    }
}