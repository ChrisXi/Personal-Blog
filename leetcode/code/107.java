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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int num = 1;
        int childNum = 0;
        List<Integer> lst = new ArrayList<Integer>();
        
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            
            if (n.left != null) { queue.offer(n.left); childNum ++;}
            if (n.right != null) { queue.offer(n.right); childNum ++;}
            
            num --;
            lst.add(n.val);
            
            if (num == 0) {
                
                num = childNum;
                childNum = 0;
                ans.add(0, lst);
                lst = new ArrayList<Integer>();
            }
        }
        
        return ans;
    }
}