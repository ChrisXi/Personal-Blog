public class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=1; i<=9; i++) {
            get(ans, i, n);
        }
        
        return ans;
    }
    
    void get(List<Integer> ans, int m, int n) {
        
        if (m>n) return;
        ans.add(m);
        
        for (int i=0; i<=9; i++) {
            int num = m*10+i;
            get(ans, num, n);
        }
    }
}