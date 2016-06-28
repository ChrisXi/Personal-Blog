public class Solution {
    public int findMin(int[] nums) {
        
        int l=0, r=nums.length-1;
        
        while (l<r-1) {
            int m = l+((r-l)>>1);
            
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] == nums[r]) {
                r --;
            } else { //nums[m] > nums[r]
                l = m;
            }
        }
        
        return Math.min(nums[l], nums[r]);
    }
}