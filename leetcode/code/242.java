public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] c = new int[26];
        
        if(s.length() != t.length())
            return false;
        
        for(int i=0; i<s.length(); i++) {
            c[s.charAt(i)-'a'] += 1;
        }
        
        for(int i=0; i<t.length(); i++) {
            c[t.charAt(i)-'a'] -= 1;
        }
        
        for(int i=0; i<s.length(); i++) {
            if (c[s.charAt(i)-'a'] != 0) {
                return false;
            }
        }
        
        return true;
    }
}