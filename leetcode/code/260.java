public class Solution {
    
    public int[] singleNumber(int[] nums) {
        
        int xor = nums[0];
        for (int i=1; i<nums.length; i++) {
            xor ^= nums[i];
        }
        
        int bit = xor & ~(xor-1);
        int ans[] = new int[2];
        
        for (int i=0; i<nums.length; i++) {
            
            if ((nums[i] & bit) == 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            } 
        }
        
        return ans;
    }
    
}