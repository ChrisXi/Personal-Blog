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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(root.left  == null ? 1:search(root.left, root.val, 1), 
                        root.right == null ? 1:search(root.right, root.val, 1));
    }
    
    int search(TreeNode root, int val, int count) {
        
        int cur = root.val==val+1 ? count+1:1;
        return Math.max(cur,
                        Math.max(root.left  == null ? cur:search(root.left,  root.val, cur), 
                        root.right == null ? cur:search(root.right, root.val, cur)));
    }
}