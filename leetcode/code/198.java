public class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        int[] pre = new int[nums.length];
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            ans[i] = Math.max(ans[i-1], pre[i-1]+nums[i]);
            pre[i] = ans[i-1];
        }
        
        return ans[nums.length-1];
    }
}