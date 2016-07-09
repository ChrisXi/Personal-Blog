public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> ans = new ArrayList<String>();
        for (int i=0; i<=nums.length; i++) {
            
            int n1 = (i==0 ? lower-1:Math.max(lower-1, nums[i-1]));
            int n2 = (i==nums.length ? upper+1:Math.min(upper+1, nums[i]));
            
            if (n1+1 < n2-1)
                ans.add((n1+1) + "->" + (n2-1));
            else if (n1+1 == n2-1)
                ans.add((n1+1) + "");
        }
        return ans;
    }
}