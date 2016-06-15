public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        
        int max = height[0], p = 0;
        
        for (int i=1; i<height.length; i++) {
            if (height[i]>max) {
                max = height[i];
                p = i;
            }
        }
        
        int ans = 0;
        int leftmax = height[0], rightmax = height[height.length-1];
        for (int i=1; i<p; i++) {
            if (height[i] > leftmax) {
                leftmax = height[i];
            } else {
                ans += (leftmax-height[i]);
            }
        }
        
        for (int i=height.length-2; i>p; i--) {
            if (height[i] > rightmax) {
                rightmax = height[i];
            } else {
                ans += (rightmax-height[i]);
            }
        }  
        
        return ans;
    }
}