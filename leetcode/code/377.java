public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        
        int[] ans = new int[target+1];
        for (int i=0; i<=target; i++) {
            for (int n:nums) {
                if (n > i) break;
                else if (n == i) ans[i] ++;
                else {
                    ans[i] += ans[i-n];
                }
            }
        }
        return ans[target];
    }
}