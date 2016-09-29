public class Solution {
    public int nthUglyNumber(int n) {
    
        if (n == 1) return 1;
        n --;
    
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        
        q1.offer(2);
        q2.offer(3);
        q3.offer(5);
        
        while (true) {
            int n1 = q1.peek(), n2 = q2.peek(), n3 = q3.peek();
            int min = Math.min(n1, Math.min(n2, n3));
            
            n --;
            if(n == 0)
                return min;
            
            if (min == n1) {
                q1.poll();
                offer(q1, n1, 2);
                offer(q2, n1, 3);
                offer(q3, n1, 5);
            } else if (min == n2) {
                q2.poll();
                offer(q2, n2, 3);
                offer(q3, n2, 5);
            } else {
                q3.poll();
                offer(q3, n3, 5);
            }
        }
    }
    
    void offer(Queue<Integer> q, int n1, int n2) {
        
        if (Integer.MAX_VALUE/n1 < n2) {
            q.offer(Integer.MAX_VALUE);
        } else {
            q.offer(n1*n2);
        }
        
    }
}