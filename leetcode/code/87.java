public class Solution {
    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) return true;
        
        int[] letters = new int[26];
        for (char c:s1.toCharArray()) letters[(int)(c-'a')]++;
        for (char c:s2.toCharArray()) letters[(int)(c-'a')]--;
        
        for (int i=0; i<26; i++) 
            if (letters[i] != 0) return false;
        
        int len = s1.length();
        for (int i=1; i<len; i++) {
            
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                isScramble(s1.substring(i), s2.substring(i)))
                return true;
                
            if (isScramble(s1.substring(0, i), s2.substring(len-i)) && 
                isScramble(s1.substring(i), s2.substring(0, len-i)))
                return true;
        }
        
        return false;
    }
}