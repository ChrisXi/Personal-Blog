/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        
        ListNode ans = new ListNode(0);
        ans.next = head;
        plus(ans);
        
        return ans.val==1 ? ans:ans.next;
    }
    
    int plus(ListNode head) {
        int carry = head.next==null ? 1:plus(head.next);
        int sum = head.val+carry;
        head.val = sum%10;
        return sum/10;
    }
}