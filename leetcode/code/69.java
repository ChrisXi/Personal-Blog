public class Solution {
    public int mySqrt(int x) {
        
        int l=0, h=x;
        if (x == 0 || x == 1) 
            return x;
        
        while(true) {
            int m = l+((h-l)>>1);
            
            if (m<=x/m && x/(m+1)<m+1) 
                return m;
            
            if (x/m < m) {
                h=m-1;
            } else {
                l=m+1;
            }
        }
        
    }
}