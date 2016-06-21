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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        
        add(ans, new ArrayList<Integer>(), root, sum);
        
        return new ArrayList<List<Integer>>(ans);
    }
    
    void add(List<List<Integer>> ans, List<Integer> lst, TreeNode root, int sum) {
        
        lst.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum-root.val == 0) {
                ans.add(new ArrayList<Integer>(lst));
            }
        }
        
        if (root.left != null) add(ans, lst, root.left, sum-root.val);
        if (root.right != null) add(ans, lst, root.right, sum-root.val);
        lst.remove(lst.size()-1);    
        return;
    }
}