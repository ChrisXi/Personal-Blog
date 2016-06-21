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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int len = preorder.length;
        if (preorder.length == 0) return null;
        
        return build(preorder, inorder, 0, len-1, 0, len-1);
    }
    
    TreeNode build(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        
        if (s1 > e1 || s2 > e2)
            return null;
        
        int n = preorder[s1];
        TreeNode root = new TreeNode(n);
        
        int p = s2;
        while (inorder[p] != n) { p ++;}
        
        int len = p-s2;
        TreeNode l = build(preorder, inorder, s1+1, s1+len, s2, p-1);
        TreeNode r = build(preorder, inorder, s1+len+1, e1, p+1, e2);
          
        root.left = l;
        root.right = r;
        
        return root;   
    }
}

/**
pre: [7,1,0,3,2,5,4,6,9,8,10]
in : [0,1,2,3,4,5,6,7,8,9,10]
*/