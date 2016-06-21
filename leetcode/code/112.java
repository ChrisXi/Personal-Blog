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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null) return false;
        
        return check(root, sum);
    }
    
    boolean check(TreeNode root, int sum) {
        
        if (root == null) {
            if (sum == 0) return true;
            return false;
        }
        
        boolean l = check(root.left, sum-root.val);
        boolean r = check(root.right, sum-root.val);
        
        if (root.right == null) return l;
        if (root.left == null) return r;
        
        return l||r;
    }
}