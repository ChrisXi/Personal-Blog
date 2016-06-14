public class Solution {
    public void nextPermutation(int[] nums) {
        
        if (nums.length <= 1) return;
    
        int max = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i]<max) {
                
                int p = i+1;
                int min = nums[p];
                for (int j=i+2; j<nums.length; j++) {
                    if (nums[i] < nums[j] && nums[j] < min) {
                        p = j;
                        min = nums[j];
                    }
                }
                nums[p] = nums[i];
                nums[i] = min;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
            
            max = nums[i];
        } 
        
        Arrays.sort(nums);  
    }
}