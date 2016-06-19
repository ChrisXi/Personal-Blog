public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        int n = (int)Math.pow(2, len);
        
        for (int i=0; i<n; i++) {
            List<Integer> lst = new ArrayList<Integer>();
            
            int bit = i;
            for (int j=0; j<len; j++) {
                if ( ((bit>>j) & 1) == 1) {
                    lst.add(nums[j]);
                }
            }
            ans.add(lst);
        }
        
        return ans;
    }
}