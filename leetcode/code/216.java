public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        addNum(ans, new ArrayList<Integer>(), k, n, 1, 0);
        
        return ans;
    }
    
    void addNum(List<List<Integer>> ans, List<Integer> cur, int k, int n, int s, int sum) {
        
        if(cur.size() > k || sum > n)
            return;
        
        if(cur.size() == k && sum == n) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        } 
        
        for(int i=s; i<=9; i++) {
            cur.add(i);
            addNum(ans, cur, k, n, i+1, sum+i);
            cur.remove(new Integer(i));
        }
    }
}