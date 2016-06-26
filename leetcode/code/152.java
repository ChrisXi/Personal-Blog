public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) 
            return 0;
        
        int ans = nums[0], min = nums[0], max = nums[0];
        for (int i=1; i<nums.length; i++) {
            int temp = min;
            min = Math.min(Math.min(min*nums[i], max*nums[i]), nums[i]);
            max = Math.max(Math.max(temp*nums[i], max*nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}