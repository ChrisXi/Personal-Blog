public class Solution {
    public int search(int[] nums, int target) {
        
        int len = nums.length;
        int start = 0;
        int end = len-1;
        
        while(start<end) {
            int mid = start + ((end-start)>>1);
            //left
            if(nums[mid] >= nums[start]) {
                if(nums[start]<=target && target<=nums[mid]) {
                    end = mid;
                } else {
                    start = mid+1;
                }
            } else {
                if(nums[mid]<target && target<=nums[end]) {
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
        }
       
        return nums[start] == target ? start:-1;
    }
}