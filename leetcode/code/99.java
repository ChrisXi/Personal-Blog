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
    
    TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    TreeNode first=null, second=null;
    
    public void recoverTree(TreeNode root) {
        
        search(root);
        
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    
    void search(TreeNode root) {
        if (root == null) return;
        
        search(root.left);
        if (first == null && root.val<=pre.val) {
            first = pre;
        }
        
        if (first != null && root.val<=pre.val) {
            second = root;
        }
        
        pre = root;
        search(root.right);
    }
}