/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode tail = head.next, pre = head, mid = head;
        
        while (tail != null) {
            pre = mid;
            mid = mid.next;
            tail = (tail.next==null ? null:tail.next.next);
        }
        
        pre.next = null;
        
        return merge(sortList(head), sortList(mid));
    }
    
    ListNode merge(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (h1 != null || h2 != null) {
            int n1 = (h1==null ? Integer.MAX_VALUE:h1.val);
            int n2 = (h2==null ? Integer.MAX_VALUE:h2.val);
            
            if (n1 < n2) {
                pre.next = h1;
                h1 = h1.next;
            } else {
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        
        return head.next;
    }
}