public class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int len = nums.length;
        int[] used = new int[len];
        
        for (int i=0; i<len; i++) {
            if (0 < nums[i] && nums[i] <= len) {
                used[nums[i]-1] = 1;
            }
        }
        
        for (int i=0; i<len; i++) {
            if (used[i] == 0)
                return i+1;
        }
        
        return len+1;
    }  
}