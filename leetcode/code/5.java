public class Solution {
    
    private int low=0, high=0;
    public String longestPalindrome(String s) {
        
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            max = checkPalindrome(s, i, i, max);
            max = checkPalindrome(s, i, i+1, max); 
        }
        
        return s.substring(low, high+1);
    }
    
    private int checkPalindrome(String s, int p1, int p2, int max) {
        
        if (0>p1 || p2>=s.length() || s.charAt(p1)!=s.charAt(p2))
            return Math.max(max, 0);
        
        while (0<=p1 && p2<s.length() && s.charAt(p1)==s.charAt(p2)) {
            p1 --;
            p2 ++;
        }
        
        int len = (--p2)-(++p1);
        
        if (len >= max) {
            low = p1;
            high = p2;
            return len;
        }
        
        return max;
    }
    
    
}