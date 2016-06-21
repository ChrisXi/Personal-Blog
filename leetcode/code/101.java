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
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        
        return check(root.left, root.right);
    }
    
    boolean check(TreeNode left, TreeNode right) {
        
        if ((left == null && right != null) ||
            (right == null && left != null))
            return false;
        
        return ((left == null) && (right == null)) ||
               (left.val == right.val && check(left.right, right.left) && check(left.left, right.right));
    }
}