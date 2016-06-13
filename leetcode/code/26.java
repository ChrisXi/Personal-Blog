public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int pre = nums[0];
        int len = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > pre) {
                nums[len ++] = nums[i];
                pre = nums[i];
            }
        }
        
        return len;
    }
}