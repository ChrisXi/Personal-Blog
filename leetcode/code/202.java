public class Solution {
    public boolean isHappy(int n) {
        /*max integer:2147483647
          so the max happy number is (9^2)*10 */
        
        int[] m = new int[810];
        
        while(n != 1) {
            n = getNum(n);
            if (m[n] == 1) {
                return false;
            }
            m[n] = 1;
        }
        
        return true;
    }
    
    public int getNum(int n) {
        
        int sum = 0;
        while(n != 0) {
            int m = n%10;
            sum += m*m;
            n /= 10;
        }
        
        return sum;
    }
}