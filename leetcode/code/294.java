public class Solution {
    public boolean canWin(String s) {
        
        char[] cs = s.toCharArray();
        for (int i=0; i<=cs.length-2; i++) {
            if (cs[i]=='+' && cs[i+1]=='+') {
                cs[i] = cs[i+1] = '-';
                
                if (!canWin(String.valueOf(cs)))
                    return true;
                
                cs[i] = cs[i+1] = '+';
            }
        }
        
        return false;
    }
}