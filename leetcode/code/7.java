public class Solution {
    public int reverse(int x) {
        
        long n = Math.abs((long)x);
        long ans = 0;
        
        while (n != 0) {
            ans = ans*10 + n%10;
            n /= 10;
        }
        
        if (ans > (long)Integer.MAX_VALUE || ans < (long)Integer.MIN_VALUE) return 0;
        
        return (x<0 ? -1:1) * (int) ans;
    }
}   