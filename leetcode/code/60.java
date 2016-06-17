public class Solution {
    public String getPermutation(int n, int k) {
        
        
        List<Integer> nums = new ArrayList<Integer>();
        for (int i=1; i<=n; i++) 
            nums.add(i);
        
        StringBuilder str = new StringBuilder("");
        k --;    
        while (n > 0) {
            int com = combineNum(--n);
            int m = k/com;
            str.append(nums.get(m));
            nums.remove(m);
            k -= m*com;
        }
            
        return str.toString();
    }
    
    int combineNum (int n) {
        int ans = 1;
        for (int i=2; i<=n; i++)
            ans *= n;
        return ans;
    } 
}