public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        
        int n1 = x;
        int n2 = 0;
        
        while (x != 0) {
            n2 = n2*10 + x%10;
            x /= 10;
        }
        
        return n1==n2;
    }
}