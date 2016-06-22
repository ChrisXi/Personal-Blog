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
    
    TreeNode pre = new TreeNode(0);
    public void flatten(TreeNode root) {
        
        if (root == null) return;
        
        pre.right = root;
        pre = root;
        
        TreeNode r = root.right;
        
        flatten(root.left);
        root.left = null;
        flatten(r);
    }
}