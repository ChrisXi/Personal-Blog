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
        
        if (head == null)
            return head;
            
        int min = head.val-1;
        int preVal = head.val;
        ListNode pre = head, next = head.next;
        
        while (next != null) {
            if (next.val == preVal) {
                pre.val = next.val = min;
            } else {
                preVal = next.val;
                pre = next;
            }
            next = next.next;
        }
        
        ListNode ans = new ListNode(0);
        ans.next = head;
        next = head;
        pre = ans;
        while (next != null) {
            if (next.val == min) {
                pre.next = next.next;    
            } else {
                pre = next;
            }
            next = next.next;
        }
        
        return ans.next;
    }
}