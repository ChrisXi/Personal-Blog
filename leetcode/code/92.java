/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode h = new ListNode(0);
        ListNode pre = h;
        ListNode loop = head;
        ListNode subhead = null,  subtail = null;
        ListNode subhead2 = null;
        
        h.next = head;
        while (loop != null) {
            
            if (--m == 0) {
                subtail = loop;
            }
            
            if (--n == 0) {
                subhead2 = loop.next;
                loop.next = null;
                subhead = reverse(subtail);
            }
            
            pre = (subtail==null ? pre.next:pre);
            loop = loop.next;
        }
     
        pre.next = subhead;
        subtail.next = subhead2;
        
        return h.next;
    }
    
    ListNode reverse(ListNode n) {
        
        if (n==null || n.next == null) 
            return n;
        
        ListNode head = reverse(n.next);
        n.next.next = n;
        n.next = null;
        return head;
    }
    
}