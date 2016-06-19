public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        
        int len = (int)Math.pow(2, nums.length);
        
        for (int i=0; i<len; i++) {
            
            List<Integer> lst = new ArrayList<Integer>();
            
            for (int j=0; j<nums.length; j++) {
                if ( ((i>>j) & 1) == 1) {
                    lst.add(nums[j]);
                }
            }
            ans.add(lst);
        }
        
        return new ArrayList(ans);
    }
}