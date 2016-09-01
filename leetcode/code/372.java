public class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        int ans = 1;
        for (int p:b) 
            ans = power(ans, 10, mod) * power(a, p, mod) % mod;
        return ans;
    }
    
    int power(int x, int n, int mod) {
        int ans = 1;
        x %= mod;
        while (n > 0) {
            if ((n&1) == 1) ans = ans*x%mod;
            x = x*x%mod;
            n >>= 1;
        }
        return ans;
    }
}