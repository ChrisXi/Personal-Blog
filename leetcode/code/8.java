public class Solution {
    public int myAtoi(String str) {
        
        if (str.length() == 0) return 0;
        
        int index = 0;
        while (str.charAt(index)==' ' && index<str.length())
            index++;
        
        int sign = 1;
        if (index<str.length() && (str.charAt(index)=='+' || str.charAt(index)=='-')) {
            sign = (str.charAt(index)=='+' ? 1:-1);
            index++;
        }
        
        long ans = 0;
        while (index<str.length() && '0' <= str.charAt(index) && str.charAt(index)<='9') {
            ans = ans*10 + (str.charAt(index)-'0');
            if (sign*ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign*ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;   
        }
        
        return sign*(int)ans;
    }
}