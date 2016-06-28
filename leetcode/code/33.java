public class Solution {
    public int search(int[] nums, int target) {
        
        int l=0, r=nums.length-1;
        while (l<r-1) {
            int m = l+((r-l)>>1);
            if (nums[m] < nums[r]) {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m;
                } else {
                    r = m;
                }
            } else {
                if (nums[l] <= target && target <= nums[m]) {
                    r = m;
                } else {
                    l = m;
                }
            }
        }
        
        return nums[r]==target ? r:(nums[l]==target ? l:-1);
    }
}