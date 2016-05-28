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
    public int rob(TreeNode root) {
        
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        
        int in=root.val, out=0;
        if(root.left != null) {
            in += (rob(root.left.left)+rob(root.left.right));
            out += rob(root.left);
        }
        if(root.right != null) {
            in += (rob(root.right.left)+rob(root.right.right));
            out += rob(root.right);
        }
        
        return (in>out ? in:out);
    }
}