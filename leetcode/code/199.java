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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) 
            return ans;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int count = 1;
        int num = 0; 
        int cur = 0;
        while(queue.size() != 0) {
            
            TreeNode node = queue.poll();
            cur ++;
            
            if(node.left != null) {
                queue.offer(node.left);
                num++;
            }
            if(node.right != null) {
                queue.offer(node.right);
                num++;
            }
            
            if(cur == count) {
                ans.add(node.val);
                
                count = num;
                num = 0;
                cur = 0;
            }
        }
        
        return ans;
    }
}