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
    public int countNodes(TreeNode root) {
        
        if (root == null)
           return 0; 
        
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        if (l == r) {
            return countNodes(root.right) + (1<<l);    
        }
        
        return countNodes(root.left) + (1<<r);
    }
    
    int getHeight(TreeNode root) {
        int h = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            h ++;
        }
        
        return h;
    }
}