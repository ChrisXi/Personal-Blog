public class Solution {
    public boolean isUgly(int num) {
        
        if (num == 0) {
            return false;
        }
        
        int n1 = getRemainder(2, num);
        int n2 = getRemainder(3, n1);
        int n3 = getRemainder(5, n2);
        
        return n3 == 1;
        
    }
    
    public int getRemainder(int divisor, int dividend) {
        
        while(dividend % divisor == 0) {
            dividend /= divisor;
        }
        
        return dividend;
    }
}