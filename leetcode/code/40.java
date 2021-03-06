public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        add (ans, candidates, new ArrayList<Integer>(), 0, target, 0);
        
        return ans;
    }
    
    void add (List<List<Integer>> ans, int[] nums, List<Integer> set, int start, int target, int sum) {
        
        if (target <= sum) {
            if (target == sum)
                ans.add(set);
            return;
        }
        
        for (int i=start; i<nums.length; ) {
            int n = nums[i];
            List<Integer> temp = new ArrayList<Integer>(set);
            temp.add(n);
            add(ans, nums, temp, i+1, target, sum+n);
            
            i++;
            while(i<nums.length && nums[i] == n) i++;
        }
    }
}