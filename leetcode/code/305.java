public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        int num = 0;
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for (int[] p:positions) {
            int parent = get1D(p[0], p[1], n);
            map.put(parent, parent);
            num ++;
            
            for (int[] dir:dirs) {
                int[] np = {dir[0]+p[0], dir[1]+p[1]};
                if (np[0] >= 0 && np[0] < m && np[1] >= 0 && np[1] < n && 
                    map.containsKey(get1D(np[0], np[1], n))) {
                    int parent1 = getParent(get1D(np[0], np[1], n), map);   
                    if (parent != parent1) {
                        num --;
                        map.put(parent1, parent);
                    }
                }
            }
            ans.add(num);
        }
        
        return ans;
    }
    
    int getParent(int p, Map<Integer, Integer> map)  {
        if (map.get(p) == p) 
            return p;
        
        return getParent(map.get(p), map);
    }
    
    int get1D(int y, int x, int w) {
        return y*w + x;
    }
}