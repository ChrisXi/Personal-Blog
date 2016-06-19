public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;        
        int len = heights.length;
        
        for (int i=0; i<=len; i++) {
            int h = (i>=len ? 0:heights[i]);
            if (stack.isEmpty() || h>=heights[stack.peek()]) {
                stack.push(i);
            } else {
                int p = stack.pop();
                ans = Math.max(ans, heights[p]*(stack.isEmpty() ? i:i-1-stack.peek()));
                i--;
            }
        }
        
        return ans;
    }
}