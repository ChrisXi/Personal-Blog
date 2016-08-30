public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    lst1.add(i);
                    lst2.add(j);
                }
            }
        }
        
        return getMin(lst1)+getMin(lst2);
    }
    
    int getMin(List<Integer> lst) {
        
        Collections.sort(lst);
        
        int ans = 0;
        int l = 0;
        int r = lst.size()-1;
    
        while(l < r) 
            ans += (lst.get(r--) - lst.get(l++));
        
        return ans;
    }
}