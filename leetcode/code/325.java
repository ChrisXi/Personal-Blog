public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i< nums.length; i++) {
            sum += nums[i];
            if (sum == k) 
                ans = i+1;
            if (map.containsKey(sum-k))
                ans = Math.max(ans, i-map.get(sum-k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return ans;
    }
}