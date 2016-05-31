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
       
       if(head == null || head.next == null || head.next.next == null) {
           return;
       }
            
       ListNode m = head;
       ListNode t = head;
       while(t.next != null && t.next.next != null) {
           m = m.next;
           t = t.next.next;
       }
       
       ListNode n = m;
       m = m.next;
       n.next = null;
       
       merge(head, reverse(m));
    }
    
    ListNode reverse(ListNode head) {
        
        if(head.next == null)
            return head;
        
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return node;
    }
    
    ListNode merge(ListNode h1, ListNode h2) {
        
        ListNode h = h1;
        
        while(h2 != null) {
            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;
            h2.next = h1.next;
            h1.next = h2;
            h1 = temp1;
            h2 = temp2;
        }
        return h;
    }  
}