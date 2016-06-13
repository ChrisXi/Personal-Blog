/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null)   return head;
        
        ListNode h = new ListNode(0);
        ListNode pre = h;
        
        ListNode post=head, next=head.next;
        while (post != null && next != null) {
            post.next = next.next;
            pre.next = next;
            next.next = post;
            
            pre = post;
            post = post.next;
            next = (post==null ? null:post.next);
        } 
         
        return h.next;
    }
}