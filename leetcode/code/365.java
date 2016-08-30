public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        
        if (x == z || y == z || x+y == z) return true;
        
        if (x == 0 || y == 0) return false;
        
        return z%divisor(x, y)==0;
    }
    
    int divisor(int x, int y) {
        if (x < y) return divisor(y, x);
        
        if (x%y == 0) return y;
        
        return divisor(x-y, y);
    }
}