public class Solution {
    public boolean isStrobogrammatic(String num) {
        int p1 = 0, p2 = num.length()-1;
        
        while(p1 < p2) {
            char c1 = num.charAt(p1++), c2 = num.charAt(p2--);
            if ((c1=='9' && c2=='6') || (c1=='6' && c2=='9') || (c1=='8' && c2=='8') || (c1=='1' && c2=='1') || (c1=='0' && c2=='0'))
                continue;
                
            return false;
        }
        
        return num.charAt(p1)=='8' || num.charAt(p1)=='1' || num.charAt(p1)=='0' || p1>p2;
    }
}   