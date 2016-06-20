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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        search(ans, root);
        
        return ans;
    }
    
    void search(List<Integer> ans, TreeNode root) {
        
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }
        search(ans, root.left);
        ans.add(root.val);
        search(ans, root.right);
    }
}