public class Solution {
    public int singleNumber(int[] nums) {
        
        int len = nums.length;
        int ans = len==0 ? 0:nums[0];
        
        for (int i=1; i<len; i++) 
            ans ^= nums[i];
        
        return ans;
    }
}