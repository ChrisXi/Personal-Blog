public class Solution {
    public boolean isReflected(int[][] points) {
        
        if (points.length <= 1) return true; 
        
        int min, max;
        min = max = points[0][0];
        HashSet<String> set = new HashSet<>();
        
        for (int[] p : points) {
            set.add(p[0]+":"+p[1]);
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
        }
        
        double y = min+((double)(max-min))/2;
        for (int[] p : points) {
            double reX = (p[0] < y ? y+(y-p[0]) : y-(p[0]-y));
            if (!set.contains((int)reX+":"+p[1]))
                return false;
        }
        
        return true;
    }
}