/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        
        int num = 1;
        int childCount = 0;
        TreeLinkNode pre = null;
        while (!queue.isEmpty()) {
            
            TreeLinkNode node = queue.poll();
            
            if (pre != null) 
                pre.next = node; 
            pre = node;
            
            if (node.left != null) { queue.offer(node.left); childCount ++; }
            if (node.right != null) { queue.offer(node.right); childCount ++; }
            
            num --;
            if (num == 0) {
                num = childCount;
                childCount = 0;
                pre = null;
            }
        }
    }
}