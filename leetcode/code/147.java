/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode ans = new ListNode(0);
        ans.next = head;
        
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode pre = ans, node = pre.next;
            ListNode temp = cur.next;
            
            while (node != null && cur.val > node.val) {
                node = node.next;
                pre = pre.next;
            }
            
            cur.next = node;
            pre.next = cur;
            
            cur = temp;
        }
        
        return ans.next;
    }
}