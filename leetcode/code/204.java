public class Solution {
    public int countPrimes(int n) {
        
        int ans = 0;
        int[] m = new int[n+1];
        for(int i=2; i<n; i++) {
            if (m[i] == 1)
                continue;
                
            ans ++;
            int s = i;
            while(n/i >= s) {
                m[i*s] = 1;
                s ++;
            }
        }
        
        return ans;
    }
}