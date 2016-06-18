public class Solution {
    public int[] plusOne(int[] digits) {
        
        int len = digits.length;
        int carry = 1;
        for (int i=len-1; i>=0; i--) {
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        
        if (carry == 1) {
            int[] ans = new int[len+1];
            ans[0] = 1;
            for (int i=1; i<len; i++)
                ans[i] = digits[i-1];
                
            return ans;
        }
        
        return digits;
        
    }
}