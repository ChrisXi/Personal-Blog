public class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        
        for (int i=1; i<=n; i++) {
            
            int len = ans.size();
            int gap = (int)Math.pow(2, i-1);
            
            for (int j=len-1; j>=0; j--) {
                ans.add(ans.get(j)+gap);
            }
        }
        
        return ans;
    }
}