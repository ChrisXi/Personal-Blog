public class Solution {
    public int removeDuplicates(int[] nums) {
        
        int len = nums.length;
        if (len == 0)
            return 0;
        
        int pre = nums[0];
        int ans = 1;
        int dupLen = 1;
        for (int i=1; i<len; i++) {
            
            if (nums[i] != pre || dupLen<2) {
               
                dupLen = nums[i]==pre ? dupLen+1:1;
                pre = nums[i];
                
                int temp = nums[i];
                nums[i] = nums[ans];
                nums[ans] = temp;
                ans ++;
            }
            
        }
        
        return ans;
    }
}