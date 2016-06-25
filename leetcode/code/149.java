/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        
        
        int len = points.length;
        int ans = len==0 ? 0:1;
        
        for (int i=0; i<len; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            Point p1 = points[i];
            int max = 1, same = 0;
            for (int j=i+1; j<len; j++) {
                Point p2 = points[j];
                if (p1.x==p2.x && p1.y==p2.y) {
                    same ++;
                    continue;
                }
                double slope = (p1.x==p2.x ? Integer.MAX_VALUE: (double)(p1.y-p2.y)/(double)(p1.x-p2.x));
                slope = (slope==0 ? 0:slope);
                int n = map.getOrDefault(slope, 1)+1;
                max = Math.max(max, n);
                map.put(slope, n);
            }
            ans = Math.max(ans, max+same);
        }
        return ans;  
    }
}