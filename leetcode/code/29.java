public class Solution {
    public int divide(int dividend, int divisor) {
        
        long sign = ((dividend<0 && 0<divisor) || (divisor<0 && 0<dividend)) ? -1:1;
        
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        
        long ans = 0;
        while (d2 <= d1) {
            
            long product = d2;
            long count = 1;
            while (product <= d1) {
                product *= 2;
                count *= 2;
            }
            
            product /= 2;
            count /= 2;
            d1 -= product;
            
            ans += count;
        }
        
        ans *= sign;
        
        ans = ans>Integer.MAX_VALUE ? Integer.MAX_VALUE:ans;   
        ans = ans<Integer.MIN_VALUE ? Integer.MIN_VALUE:ans;
          
        return (int)ans;
    }
}