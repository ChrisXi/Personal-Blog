public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        get(ans, new ArrayList<Integer>(), n, 2);
        return ans;
    }
    
    void get(List<List<Integer>> ans, List<Integer> lst, int n, int s) {
        
        if (n <= 1) {
            if(lst.size() > 1)
                ans.add(new ArrayList<Integer>(lst));
            return;
        }
        
        for (int i=s; i<=n; i++) {
            if (n%i == 0) {
                lst.add(i);
                get(ans, lst, n/i, i);
                lst.remove(lst.size()-1);
            }
        }
    }
}