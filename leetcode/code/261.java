public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int[] edge:edges) {
            int i = find(nums, edge[0]);
            int j = find(nums, edge[1]);
            
            if (i == j)
                return false;
            
            nums[i] = j;
        }
        
        return edges.length == n-1;
    }
    
    int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}