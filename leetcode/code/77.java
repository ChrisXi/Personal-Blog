public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] nums = new int[n];
        for (int i=1; i<=n; i++)
            nums[i-1] = i;
        
        add(ans, nums, new ArrayList<Integer>(), 0, k);
        
        return ans;
    }
    
    void add(List<List<Integer>> ans, int[] nums, List<Integer> lst, int s, int k) {
        
        if (k == 0) {
            ans.add(new ArrayList<Integer>(lst));
            return;
        }
        
        for (int i=s; i<nums.length; i++) {
            lst.add(nums[i]);
            add(ans, nums, lst, i+1, k-1);
            lst.remove(lst.size()-1);
        }
        
    }
}