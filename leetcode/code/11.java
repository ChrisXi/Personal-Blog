public class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int l=0, h=height.length-1;
        
        while (l<h) {
            int area = (h-l);
            
            if (height[l] < height[h]) {
                area *= height[l];
                l++;
            } else {
                area *= height[h];
                h--;
            }
            
            ans = Math.max(ans, area);
        }
        
        return ans;
    }
}