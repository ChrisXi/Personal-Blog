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
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        return count(root)[0];
    }
    
    int[] count(TreeNode root) {
        
        int[] left  = root.left==null  ? new int[]{0, 1, root.val}:count(root.left);
        int[] right = root.right==null ? new int[]{0, 1, root.val}:count(root.right);
        
        boolean same = left[1]==1 && right[1]==1 && left[2]==root.val && right[2]==root.val;
        
        return new int[]{left[0]+right[0]+(same ? 1:0),
                         same ? 1:0,
                         root.val};
    }
}