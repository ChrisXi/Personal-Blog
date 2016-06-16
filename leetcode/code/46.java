public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> num = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++)
            num.add(nums[i]);
            
        add(ans, num, new ArrayList<Integer>());
        
        return ans;
    }
    
    void add(List<List<Integer>> ans, List<Integer> nums, List<Integer> set) {
        
        if (nums.size() == 0) {
            ans.add(set);
            return;
        }
        
        for (int i=0; i<nums.size(); i++) {
            int n = nums.get(i);
            List<Integer> temp = new ArrayList<Integer>(set);
            temp.add(n);
            
            nums.remove(i);
            add(ans, nums, temp);
            
            nums.add(i, n);
        }
    }
}