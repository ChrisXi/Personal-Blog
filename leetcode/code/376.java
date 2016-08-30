public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        
        int ans = 1;
        int n1 = nums[0], n2 = nums[1];
        int i = 1;
        while (i < nums.length && nums[i] == n1) 
            i ++;
        n2 = nums[i>=nums.length ? 0:i];
        ans += (n1==n2 ? 0:1);
        for (;i<nums.length; i++) {
            if (n2 != nums[i] && (n2-n1)/Math.abs(n2-n1) != (nums[i]-n2)/Math.abs(nums[i]-n2)) {
                n1 = n2;
                ans ++;
            }
            n2 = nums[i];
        }
        
        return ans;
    }
}