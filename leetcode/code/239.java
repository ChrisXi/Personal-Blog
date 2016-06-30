public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        if (len == 0 || len < k) return new int[0];
        
        int[] ans = new int[len-k+1];
        
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i=0; i<len; i++) {
            if (i >= k && deque.peekFirst() == nums[i-k])
                deque.pollFirst();
                
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(nums[i]);
            if (i >= k-1) 
                ans[i-k+1] = deque.peekFirst();
        }
        
        return ans;  
    }
}