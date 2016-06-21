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
    public boolean isBalanced(TreeNode root) {
        
        return balanced(root)!=-1;
    }
    
    int balanced(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int left = balanced(root.left);
        int right = balanced(root.right);
        
        return (left==-1 || right==-1 || Math.abs(left-right)>1) ? -1:Math.max(left, right)+1;
    }
}