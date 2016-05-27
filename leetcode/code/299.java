import java.util.HashMap;

public class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        int len = secret.length();
        
        for (int i=0; i<len; i++) {
            char c1 = secret.charAt(i), c2 = guess.charAt(i);
            if (c1 == c2) {
                a ++;
            } else {
                int n1 = map2.getOrDefault(c1, 0);
                if (n1 > 0) {
                    b ++;
                    map2.put(c1, n1-1);
                } else {
                    int n = map1.getOrDefault(c1, 0);
                    map1.put(c1, n+1);
                }
                
                int n2 = map1.getOrDefault(c2, 0);
                if (n2 > 0) {
                    b ++;
                    map1.put(c2, n2-1);
                } else {
                    int n = map2.getOrDefault(c2, 0);
                    map2.put(c2, n+1);
                }
            }
        }
        
        return a+"A"+b+"B";
    }
}   