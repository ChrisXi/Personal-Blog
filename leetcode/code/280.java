public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if (i%2 == 0) {
                if (i != 0 && nums[i] > nums[i-1])
                    swap(nums, i);
            } else {
                if (nums[i] < nums[i-1])
                    swap(nums, i);
            }
        }
    }
    
    void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = temp;
    }
}