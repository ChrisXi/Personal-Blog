public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[]{-1,-1};
        int l=0, h=nums.length-1;
        
        while (l<=h) {
            
            int m = l+((h-l)>>1);
            if (target <= nums[m]) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        
        if (! (l<nums.length && nums[l]==target)) 
            return ans;
        
        ans[0] = l;
        h=nums.length-1;
        while (l<=h) {
            int m = l+((h-l)>>1);
            if (target+1 <= nums[m]) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        ans[1] = h;
        return ans;
    }
}