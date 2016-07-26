public class Solution {
    public boolean canPermutePalindrome(String s) {
        
        int[] cs = new int[128];
        for (char c:s.toCharArray()) 
            cs[c] ++;
        
        int single = 0;
        for (int i=0; i<128; i++) {
            if (cs[i]%2 != 0) {
                if (single != 0)
                    return false;
                single = 1;
            }
        }
        return true;
    }
}