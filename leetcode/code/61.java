/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode h = new ListNode(0);
        
        ListNode next = head;
        ListNode tail = head;
        int len = 0;
        while (next != null) {
            tail = next;
            next = next.next;
            len ++;
        }
        if (len == 0 || k%len == 0) 
            return head;
        
        k = k%len;
        
        next = head;
        ListNode pre = head;
        
        while (next != null) {
            pre = k >= 0 ? pre:pre.next;
            k --;
            next = next.next;
        }
        
        ListNode temp = pre.next;
        pre.next = null;
        h.next = temp;
        tail.next = head;
        
        return h.next;
    }
}