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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        List<Integer> lst = new ArrayList<Integer>();
        int num = 1;
        int childNum = 0;
        while(!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            lst.add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                childNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                childNum++;
            }
            
            num --;
            if (num == 0) {
                ans.add(lst);
                lst = new ArrayList<Integer>();
                num = childNum;
                childNum = 0;
            } 
        }
        
        return ans;
    }
}