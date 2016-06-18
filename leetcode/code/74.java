public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int h=matrix.length, w=matrix[0].length;
        int low=0, high = h*w-1;
        
        while (low<=high) {
            
            int mid = low+((high-low)>>1);
            int i = mid/w, j = mid%w;
            
            if (target <= matrix[i][j]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return low<h*w && matrix[low/w][low%w]==target;
    }
}