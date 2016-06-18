public class Solution {
    public void sortColors(int[] nums) {
        
        int l=0, h=nums.length-1;
        int p=0;
        while (l<=h) {
            
            if (nums[l] == 2) {
                swap(nums, l, h);
                h --;
            } else if (nums[l] == 0) {
                swap(nums, l, p);
                l ++;
                p ++;
            } else {
                l ++;
            }
        }
    }
    
    void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}