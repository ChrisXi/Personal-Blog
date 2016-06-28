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
    
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
            
        maxChild(root);
        return ans;
    }
    
    int maxChild(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, maxChild(root.left));
        int r = Math.max(0, maxChild(root.right));
        
        ans = Math.max(ans, l+root.val+r);
        
        return Math.max(l,r)+root.val;
    }
}