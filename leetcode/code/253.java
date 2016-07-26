/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();
        
        for (Interval interval:intervals) {
            queue1.offer(interval.start);
            queue2.offer(interval.end);
        }
        
        int ans = 0, cur = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int s = queue1.isEmpty() ? Integer.MAX_VALUE:queue1.peek();
            int e = queue2.isEmpty() ? Integer.MAX_VALUE:queue2.peek();
            
            if (s < e) {
                cur ++;
                queue1.poll();
            } else {
                cur --;
                queue2.poll();
            }
             
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}