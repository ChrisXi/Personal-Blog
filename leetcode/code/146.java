class ListNode {
    int value;
    int key;
    ListNode pre,next;
    ListNode(int value, int key) {
        this.value = value;
        this.key = key;
    }
}

public class LRUCache {
    
    Map<Integer, ListNode> map;
    ListNode head,tail;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(0, -1);
        tail = new ListNode(0, -1);
        head.next = tail;
        tail.pre = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if (! map.containsKey(key)) {
            return -1;
        } else {
            ListNode n = map.get(key);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            
            insert(n);
            return n.value;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode n = map.get(key);
            n.value = value;
            n.pre.next = n.next;
            n.next.pre = n.pre;
            insert(n);
        } else {
            ListNode n = new ListNode(value, key);
            if (cap == 0) {
                ListNode last = tail.pre;
                last.pre.next = tail;
                tail.pre = last.pre;
                map.remove(last.key);
                insert(n);
            } else {
                cap --;
                insert(n);
            }
            map.put(key, n);
        }
    }
    
    void insert(ListNode n) {
        ListNode next = head.next;
        head.next = n;
        next.pre = n;
        n.pre = head;
        n.next = next;
    }
}