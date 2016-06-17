/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
class IntervalComparator implements Comparator<Interval> {

    public int compare(Interval n1, Interval n2) {
        return n1.start - n2.start;
    }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> ans = new ArrayList<Interval>();
        if (intervals.size() == 0) return ans;
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new IntervalComparator());
        for (Interval interval:intervals) 
            queue.offer(interval);
        
        Interval interval = queue.poll();
        
        while (queue.size() != 0) {
            Interval temp = queue.poll();    
            if (temp.start <= interval.end) {
                interval.end = Math.max(temp.end, interval.end);
            } else {
                ans.add(interval);
                interval = temp;
            }
        }
        
        ans.add(interval);
        return ans;
    }
}