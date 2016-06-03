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
    public int kthSmallest(TreeNode root, int k) {
    
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = root;
        
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        
        while(k > 0) {
            k--;
            TreeNode n = stack.pop();
            if(k == 0)
                return n.val;
            
            if(n.right != null) {
                node = n.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return -1;
    }
}