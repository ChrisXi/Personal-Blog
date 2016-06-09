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
    public int maxPathSum(TreeNode root) {
        
        int[] val = search(root);
        return Math.max(val[0], val[1]);
    }
    
    int[] search(TreeNode root) {
        
        int[] node = new int[2];
        if (root == null)
            return node;
            
        int[] left = search(root.left);
        int[] right = search(root.right);
        int val = root.val;
        
        left[0] = root.left==null ? Integer.MIN_VALUE:left[0];
        right[0] = root.right==null ? Integer.MIN_VALUE:right[0];
        
        node[0] = Math.max(left[1]+val+right[1],
                  Math.max(left[1]+val, 
                  Math.max(right[1]+val,
                  Math.max(right[0],left[0])))); //with root node
        node[1] = Math.max(val, 
                  Math.max(val+left[1], val+right[1])); //without root node
                  
        return node;
    }
}