/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null) return null;
        
        ListNode fast=head, slow=head;
        
        while (fast != null) {
            fast = (fast.next==null ? fast.next:fast.next.next);
            slow = slow.next;
            
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                break;
            }
        }
        
        return fast;
    }
}