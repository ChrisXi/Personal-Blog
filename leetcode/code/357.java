public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        if (n == 0) return 1;
        
        int ans = 10;
        int pre = 9;
        int i = 2;
        while (i <= n) {
            pre = pre*(9-i+2);
            i++;
            ans += pre;
        }
        
        return ans;
    }
}