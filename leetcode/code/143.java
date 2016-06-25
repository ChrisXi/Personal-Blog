/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
            
        ListNode pre = head, mid = head.next;
        
        while (mid != null && mid.next != null) {
            pre = pre.next;
            mid = (mid.next==null ? null:mid.next.next);
        }
        
        mid = pre.next;
        pre.next = null;
        
        merge(head, reverse(mid));
    }
    
    void merge(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            ListNode next1 = h1.next, next2 = h2.next;
            h1.next = h2;
            h2.next = next1;
            h1 = next1;
            h2 = next2;
        }
    }
    
    ListNode reverse(ListNode n) {
        if (n.next == null) return n;
        
        ListNode head = reverse(n.next);
        n.next.next = n;
        n.next = null;
        
        return head;
    }
}