/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class NodeComparator implements Comparator<ListNode> {
    
    public int compare(ListNode n1, ListNode n2) {
        return Integer.compare(n1.val, n2.val);
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new NodeComparator());
        
        for (int i=0; i<lists.length; i++)
            if (lists[i] != null)
                queue.offer(lists[i]);
        
        ListNode head = null;
        ListNode next = null;
        
        while (queue.size() != 0) {
            ListNode top = queue.poll();
            ListNode temp = new ListNode(top.val);
            
            if (head == null) {
                head = temp;
                next = temp;
            } else {
                next.next = temp;
                next = temp;
            }
            
            if (top.next != null)
                queue.offer(top.next);
        }
        
        return head;
    }
}