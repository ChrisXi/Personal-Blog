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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> ans = new ArrayList<Interval>();
        
        for (Interval interval:intervals) {
            if (newInterval.start > interval.end) {
                ans.add(interval);
            } else if (newInterval.end < interval.start) {
                ans.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new Interval(Math.min(newInterval.start, interval.start), 
                                           Math.max(newInterval.end, interval.end));
            }
        }
        ans.add(newInterval);
        return ans;
    }
}