public class Solution {
    public boolean isPerfectSquare(int num) {
        
        int low = 1, high = num;
        while (low <= high) {
            int n1 = low + ((high-low) >> 1);
            int n2 = num/n1 + (num%n1==0 ? 0:1);
            if (n1 == n2 && num%n1==0) return true;
            else if (n1 < n2) low = n1+1;
            else high = n1-1;
        }
        
        return false;
    }
} 