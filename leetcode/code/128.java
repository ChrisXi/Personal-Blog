public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            
            if (! map.containsKey(nums[i])) {
                
                int l = map.getOrDefault(nums[i]-1, 0);
                int r = map.getOrDefault(nums[i]+1, 0);
                
                int sum = l+r+1;
                ans = Math.max(sum, ans);
                
                map.put(nums[i], sum);
                map.put(nums[i]-l, sum);
                map.put(nums[i]+r, sum);
            }
        }
        
        return ans;
    }
}