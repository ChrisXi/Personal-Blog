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
        
        TreeLinkNode cur = null, next = root;
        
        while (next != null) {
            cur = next;
            next = null;
            TreeLinkNode pre = null;
            while (cur != null) {
                next = (next!=null) ? next:((cur.left!=null) ? cur.left:cur.right);
                
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                
                cur = cur.next;
            }
        }
    }
}