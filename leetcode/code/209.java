public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int l=0, h=0;
        
        int sum=0;
        int ans = Integer.MAX_VALUE;
        
        while (l<nums.length) {
            
            if (sum >= s) {
                ans = Math.min(ans, h-l);
                sum -= nums[l++];
            } else {
            	if (h>=nums.length)
            		break;
                sum += nums[h++];
            }
            
        }
        
        if (ans == Integer.MAX_VALUE) return 0;
        
        return ans;
    }
}