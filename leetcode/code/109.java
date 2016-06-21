/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        return build(head);
    }
    
    TreeNode build(ListNode node) {
        
        if (node == null || node.next == null) 
            return node==null ? null:new TreeNode(node.val);
        
        ListNode slow = node, fast = node, pre = node;
        
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = (fast.next==null ? fast.next:fast.next.next);
        }
        
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        
        TreeNode l = build(node);
        TreeNode r = build(slow.next);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}