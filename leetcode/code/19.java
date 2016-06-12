/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode l=null, h=head;
        
        while (--n != 0) {
            h = h.next;
        }
        
        while(h.next != null) {
            l = l==null ? head:l.next;
            h = h.next;
        }
        
        if (l == null) 
            return head.next;
        
        l.next = l.next.next;
          
        return head;
    }
}