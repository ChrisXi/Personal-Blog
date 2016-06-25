/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    
    Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)  return null;
        
        if (map.containsKey(head.label)) return map.get(head.label);
        
        RandomListNode node = new RandomListNode(head.label);
        map.put(head.label, node);
        
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        map.put(head.label, node);
        
        return node;   
    }
}