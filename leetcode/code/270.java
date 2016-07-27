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
    public int closestValue(TreeNode root, double target) {
    
        return close(root, target, -1);
    }
    
    int close(TreeNode root, double target, int parent) {
        if (root == null) return parent;
        
        int child = ((double)root.val > target) ? close(root.left, target, root.val):close(root.right, target, root.val);
            
        return Math.abs((double)root.val-target) > Math.abs((double)child-target) ? child:root.val;
    }
}