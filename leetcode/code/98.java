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
    public boolean isValidBST(TreeNode root) {
        
        if (root == null)
            return true;
        
        return isBST(root.left,  (long)Integer.MIN_VALUE-1, root.val) && 
               isBST(root.right, root.val, (long)Integer.MAX_VALUE+1);
    }
    
    boolean isBST(TreeNode root, long min, long max) {
        
        if (root == null)
            return true;
        
        return min<root.val && root.val<max &&
               isBST(root.left,  min, root.val) && 
               isBST(root.right, root.val, max);
    }
}