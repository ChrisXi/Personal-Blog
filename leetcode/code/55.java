public class Solution {
    public boolean canJump(int[] nums) {
    
        int p = 0;
        
        for (int i=0; i<nums.length; i++) 
            p = i<=p ? Math.max(p, i+nums[i]):0;
        
        return nums.length<=p+1;
        
    }
}