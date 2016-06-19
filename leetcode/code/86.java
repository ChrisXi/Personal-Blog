/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        
        ListNode pre1=head1, pre2=head2;
        ListNode loop = head;
        
        while (loop != null) {
            if (loop.val < x) {
                pre1.next = loop;
                pre1 = pre1.next;
            } else {
                pre2.next = loop;
                pre2 = pre2.next;
            }
            loop = loop.next;
            pre1.next = null;
            pre2.next = null;
        }
        
        if (head1.next != null) {
            pre1.next = head2.next;
            return head1.next;
        }

        return head2.next;
    }
}