public class Solution {
    
    public int integerBreak(int n) {
        
        if(n < 3) return 1;
        if(n == 3) return 2;
        
        int n_3 = n/3;
        int n_2 = n%3;
        if(n_2 == 1) {
            n_3 --;
            n_2 = 2;
        } else if (n_2 == 2) {
            n_2 = 1;
        }
        
        return (int)Math.pow(3, n_3) * (int)Math.pow(2, n_2);
        
    }
  
}