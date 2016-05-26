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
    public TreeNode invertTree(TreeNode root) {
        revert(root);
        
        return root;
    }
    
    public void revert(TreeNode n) {
        if (n == null)
            return;
            
        TreeNode left = n.left;
        TreeNode right = n.right;
        
        n.left = right;
        n.right = left;
        
        revert(n.left);
        revert(n.right);
    }
}