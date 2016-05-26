import java.util.HashSet;

public class Solution {
    public String reverseVowels(String s) {
        
        HashSet<Character> map = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        int p1 = 0;
        int p2 = s.length()-1;
        
        char[] c = s.toCharArray();
        
        while(p1<p2) {
            while(p1<p2 && !map.contains(Character.toLowerCase(c[p1]))) {
                p1++;
            }
            
            while(p1<p2 && !map.contains(Character.toLowerCase(c[p2]))) {
                p2--;
            }
            
            char temp = c[p1];
            c[p1++] = c[p2];
            c[p2--] = temp;
        }
       
        return new String(c);
        
    }
}