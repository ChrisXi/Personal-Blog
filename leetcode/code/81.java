public class Solution {
    public boolean search(int[] nums, int target) {
        
        int len=nums.length;
        int l=0, h=len-1;
        
        while(l<=h) {
            int m = l+((h-l)>>1);
            if(target == nums[m]) return true;
            
            if (nums[m] == nums[l]) {
                l++;
            }else if(nums[l] < nums[m]) {
                if(nums[l]<=target && target<nums[m]) {
                    h = m-1;
                } else {
                    l = m+1;
                }
            } else {
                if(nums[m]<target && target<=nums[h]) {
                    l = m+1;
                } else {
                    h = m-1;
                }
            }
        }
        
        return false;
    }
}