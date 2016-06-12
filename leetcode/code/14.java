public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder str = new StringBuilder("");
        if (strs.length == 0) return str.toString();
        
        int len=0;
        while (true) {
            
            if (len>=strs[0].length())
                return str.toString();
            
            char c = strs[0].charAt(len);
            for (int i=1; i<strs.length; i++) {
                if (len>=strs[i].length() || strs[i].charAt(len)!=c) {
                    return str.toString();
                }
            }
            str.append(c);
            len ++;
        }
        
        // return str.toString();
    }
}