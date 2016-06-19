public class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix.length == 0)
            return 0;
    
        int h=matrix.length, w=matrix[0].length;
        int[] dp = new int[w];
        int ans = 0;
        
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                dp[j] = (matrix[i][j]=='0' ? 0:dp[j]+1);
            }    
            ans = Math.max(ans, getMaxHistogram(dp));
        }
        
        return ans;
    }
    
    int getMaxHistogram(int[] heights) {
        
        int max = 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i=0; i<=len; i++) {
            int h = (i>=len ? 0:heights[i]);
            if (stack.isEmpty() || h>=heights[stack.peek()]) {
                stack.push(i);
            } else {
                int p = stack.pop();
                max = Math.max(max, heights[p]*(stack.isEmpty() ? i:i-1-stack.peek()));
                i--;
            }
        }
        
        return max;
    }
}