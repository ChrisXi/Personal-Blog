public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        
        int p1 = 0;
        int p2 = c.length-1;
        
        while(p1 < p2) {
            char temp = c[p1];
            c[p1++] = c[p2];
            c[p2--] = temp;
        }
        
        return new String(c);
        
    }
}