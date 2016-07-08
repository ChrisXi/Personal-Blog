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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        
        TreeNode node = upsideDownBinaryTree(root.left);
        upsideDownBinaryTree(root.right);
        
        TreeNode right = root.right, left = root.left;
        root.right = null;
        root.left = null;
        left.right = root;
        left.left = right;
        
        return node;
    }
}