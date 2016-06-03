public class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int p = Arrays.binarySearch(dp, 0, len, num);
            p = (p>=0 ? p:-(p+1));
            dp[p] = num;
            if(p == len)
                len++;
        }
        
        return len;
    }
}