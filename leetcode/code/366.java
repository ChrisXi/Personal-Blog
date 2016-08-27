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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        while (root != null && (root.left != null || root.right != null)) {
            List<Integer> lst = new ArrayList<Integer>();
            getList(lst, root);
            ans.add(lst);
        }
        
        if (root != null) 
            ans.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{root.val})));
        

        return ans;
    }
    
    boolean getList(List<Integer> lst, TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            lst.add(root.val);
            return true;
        }
        if (getList(lst, root.left))
            root.left = null;
        if (getList(lst, root.right))
            root.right = null;
        
        return false;
    }
}