/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        ListNode next = null;
        
        while (l1!=null || l2!=null) {
            int n1 = (l1==null ? Integer.MAX_VALUE:l1.val);
            int n2 = (l2==null ? Integer.MAX_VALUE:l2.val);
            
            ListNode temp = new ListNode(Math.min(n1, n2));
            
            if (head == null) {
                head = temp;
                next = temp;
            } else {
                next.next = temp;
                next = temp;
            }
            
            if (n1 < n2) {
                l1 = l1.next;    
            } else {
                l2 = l2.next;
            }
        }
        
        return head;
    }
}