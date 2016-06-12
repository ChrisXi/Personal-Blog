public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for (int i=0; i<nums.length-2; i++) {
            
            int l=i+1, h=nums.length-1;
            while (l<h) {
                
                int sum = nums[i]+nums[l]+nums[h];
                
                if (Math.abs(target-sum) < min) {
                    min = Math.abs(target-sum);
                    ans = sum;
                }
                
                if (sum<target) {
                    l ++;
                } else {
                    h--;
                }
            }
        }
        
        return ans;
    }
}