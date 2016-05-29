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
    
    public List<TreeNode> generateTrees(int n) {
        
        if(n == 0) return new ArrayList<TreeNode>();
        
        return getTreeNode(1, n);
    }
    
    public List<TreeNode> getTreeNode(int s, int e) {
        
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(s>e) {
            ans.add(null);
            return ans;
        }
        
        for(int i=s; i<=e; i++) {
            List<TreeNode> lefts = getTreeNode(s, i-1);
            List<TreeNode> rights = getTreeNode(i+1, e);
            
            for(TreeNode left: lefts) {
                for(TreeNode right:rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}