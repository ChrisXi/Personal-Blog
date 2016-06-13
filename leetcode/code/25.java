/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode h = new ListNode(0);
        ListNode pre = h;
        pre.next = head;
        
        ListNode post=head, next=head;
        int n = 1;
        
        while (next != null) {
            if (n == k) {
                ListNode temp = next.next;
                next.next = null;
                ListNode t = reverse(post);
                
                pre.next = t;
                pre = post;
                post.next = temp;
                post = temp;
                next = temp;   
                
                n = 1;
            } else {
                n ++;
                next = next.next;                                                                                       
            }
        }
        
        return h.next;
        
    }
    
    ListNode reverse(ListNode root) {
        if (root.next == null) return root;
        
        ListNode tail = reverse(root.next);
        ListNode next = root.next;
        root.next = null;
        next.next = root;    
        
        return tail;
    }
}