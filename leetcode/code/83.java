/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode pre = head;
        ListNode next = head.next;
        
        while (next != null) {
            if (next.val == pre.val) {
                pre.next = next.next;
            } else {
                pre = next;
            }
            next = next.next;
        }
        
        return head;
    }
}