public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cs = new int[26];
        for (int i=0; i<ransomNote.length(); i++) 
            cs[ransomNote.charAt(i)-'a'] ++;
        for (int i=0; i<magazine.length(); i++) 
            cs[magazine.charAt(i)-'a'] --;
        
        for (int i=0; i<26; i++) {
            if (cs[i] > 0)
                return false;
        }
        
        return true;
    }
}