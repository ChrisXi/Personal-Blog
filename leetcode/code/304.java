public class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int h = matrix.length+1;
        if(h == 1)
            return;
            
        int w = matrix[0].length+1;
        sum = new int[h][w];
        
        for (int i=0; i<h; i++) 
            sum[i][0] = 0;
        
        for (int j=0; j<w; j++) 
            sum[0][j] = 0;
        
        for (int i=1; i<h; i++) {
            for (int j=1; j<w; j++) {
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        return sum[row2+1][col2+1]-sum[row2+1][col1]-sum[row1][col2+1]+sum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);