public class Solution {
    public int strStr(String haystack, String needle) {
        
        int l = 0;
        int len1 = haystack.length(), len2 = needle.length();
        
        while (l <= len1-len2) {
            
            String substr = haystack.substring(l, l+len2);
            if (substr.equals(needle)) 
                return l;
            
            l ++;
        }
        
        return -1;
    }
}