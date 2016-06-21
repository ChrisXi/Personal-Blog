/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return get(nums, 0, nums.length-1);
    }
    
    TreeNode get(int[] nums, int s, int e) {
        
        if (s > e)
            return null;
        
        int m = (s+((e-s)>>1));
        TreeNode root = new TreeNode(nums[m]);
        
        TreeNode l = get(nums, s, m-1);
        TreeNode r = get(nums, m+1, e);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}