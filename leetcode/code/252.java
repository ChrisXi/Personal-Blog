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
    public boolean canAttendMeetings(Interval[] intervals) {
        
        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b)->(a.start-b.start));
        for (Interval interval:intervals)
            queue.offer(interval);
        
        Interval interval = queue.poll();
        while (!queue.isEmpty()) {
            Interval temp = queue.poll();
            if (temp.start < interval.end)
                return false;
            interval = temp;
        }
        
        return true;
    }
}