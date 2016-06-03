public class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
        if(nums.length == 0)
            return nums;
        
        int[] ans = new int[nums.length];
        //find # of zeros
        int p = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0 && p != -1)
                return ans;
            p = (nums[i]==0 ? i:p);
        }
        
        if(p != -1) {
            int pro = 1;
            for(int i=0; i<nums.length; i++) {
                if(i != p)
                    pro *= nums[i];
            }
            ans[p] = pro;
        } else {
            int pro = 1;
            for(int i=1; i<nums.length; i++) {
                pro *= nums[i];
            }
            ans[0] = pro;
            for(int i=1; i<nums.length; i++) {
                pro = pro/nums[i]*nums[i-1];
                ans[i] = pro;
            }
        }
        
        return ans;
    }
}