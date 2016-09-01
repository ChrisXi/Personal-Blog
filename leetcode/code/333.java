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
    
    public int largestBSTSubtree(TreeNode root) {
        
        if (root == null) return 0;
        
        return getNum(root);
    }
    
    int getNum(TreeNode root) {
        int self = validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        int left = root.left == null ? 0:getNum(root.left);
        int right = root.right == null ? 0:getNum(root.right);
        
        return Math.max(Math.max(left, right), self);
    }
    
    int validateBST(TreeNode root, int max, int min) {
        
        if (root.val >= max || root.val <= min) return 0;
        if (root.left == null && root.right ==null) return 1;
        
        int left  = root.left  == null ? 0:validateBST(root.left, root.val, min);
        int right = root.right == null ? 0:validateBST(root.right, max, root.val);
        
        if ((root.left != null && left == 0) || (root.right != null && right == 0)) return 0;
            
        return left+right+1;    
    }
    
    
}