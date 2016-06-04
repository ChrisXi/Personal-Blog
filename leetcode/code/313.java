public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        if (--n == 0 || primes.length == 0)
            return 1;

        List<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();
        for (int i=0; i<primes.length; i++) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(primes[i]);
            queues.add(queue);
        }
        
        while (true) {
            
            int min = queues.get(0).peek();
            int pos = 0;
            for (int i=1; i<primes.length; i++) {
                if (queues.get(i).peek() < min) {
                    min = queues.get(i).peek();
                    pos = i;
                }
            }
            
            if (--n == 0)
                return min;
            
            queues.get(pos).poll();  
            for (int i=pos; i<primes.length; i++) {
                queues.get(i).offer(min*primes[i]);
            }
            
        }
    }  
}