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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int len = inorder.length;
        if (len == 0) return null;
        
        return build(inorder, postorder, 0, len-1, 0, len-1);
    }
    
    TreeNode build(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        
        if (s1 > e1 || s2 > e2) 
            return null;
        
        int n = postorder[e2];
        TreeNode root = new TreeNode(n);
        
        int p = s1;
        while(inorder[p] != n) { p++; }
        
        int len = p-s1;
        TreeNode l = build(inorder, postorder, s1, p-1, s2, s2+len-1);
        TreeNode r = build(inorder, postorder, p+1, e1, s2+len, e2-1);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}

/**
in  : [0,1,2,3,4,5,6,7,8,9,10]
post: [0,2,4,6,5,3,1,8,10,9,7]
*/