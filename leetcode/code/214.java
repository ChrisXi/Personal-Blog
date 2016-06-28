public class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j ++;
            }
        }
        
        if (j == s.length()) return s;
        String prefix = s.substring(j);
        return new StringBuilder(prefix).reverse().toString()+shortestPalindrome(s.substring(0, j))+prefix;
        
    }
}