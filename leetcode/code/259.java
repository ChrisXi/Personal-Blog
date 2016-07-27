public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        Arrays.sort(nums);
        int ans = 0;
        for (int i=0; i<nums.length-2; i++) {
            int p1 = i+1;
            int p2 = nums.length-1;
            
            while (p1<p2) {
                int sum = nums[i]+nums[p1]+nums[p2];
                if (sum < target) {
                    ans += (p2-p1);
                    p1 ++;
                } else {
                    p2 --;
                }
            }
        }
        
        return ans;
    }
}