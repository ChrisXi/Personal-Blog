public class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();
        if (s.split("\\s+").length != 1 || s.length() == 0) 
            return false;
        
        StringBuilder str1 = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");
        
        boolean findE = false;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'e') {
                if (findE) return false;
                findE = true;    
            } else if (findE) {
                str2.append(c);
            } else {
                str1.append(c);
            }
        }

        StringBuilder str11 = new StringBuilder("");
        StringBuilder str12 = new StringBuilder("");
        boolean findDot = false;
        for (int i=0; i<str1.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (findDot) return false;
                findDot = true;    
            } else if (findDot) {
                str12.append(c);
            } else {
                str11.append(c);
            }
        }
        
        str11 = removeSign(str11);
        str2 = removeSign(str2);
        
        if ( (findE && str2.length() == 0) || (str11.length()==0 && str12.length()==0) )
            return false;

        return checkDigit(str11) && checkDigit(str12) && checkDigit(str2);
    }
    
    boolean checkDigit(StringBuilder s) {
        for (int i=0; i<s.length(); i++) 
            if (! Character.isDigit(s.charAt(i)))
                return false;
        return true; 
    }
    
    StringBuilder removeSign(StringBuilder s) {
        if (s.length() == 0) return s;
        
        if (s.charAt(0)=='+' || s.charAt(0)=='-')
            return new StringBuilder(s.substring(1));
            
        return s;
    }
}