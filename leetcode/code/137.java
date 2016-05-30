public class Solution {
    public int singleNumber(int[] nums) {
        
        int ans = 0;
        for(int i=0; i<31; i++) {
            int m = 0;
            for(int n=0; n<nums.length; n++) {
                m += ((nums[n] & (1 << i)) >> i);
            }
            m %= 3;
            ans |= (m << i);
        }
        
        return ans;
    }
}