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
    public int sumNumbers(TreeNode root) {
        
        if (root == null) return 0;
        
        return getNum(root, new StringBuilder(""));
    }
    
    int getNum (TreeNode root, StringBuilder str) {
        
        str.append(root.val);
        if (root.left == null && root.right == null) 
            return Integer.parseInt(str.toString());
        
        int left = (root.left==null ? 0:getNum(root.left, new StringBuilder(str)));
        int right = (root.right==null ? 0:getNum(root.right, new StringBuilder(str)));
        
        return left+right;    
    }
}