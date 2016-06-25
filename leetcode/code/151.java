public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        int len = strs.length;
        
        StringBuilder ans = len-1>=0 ? new StringBuilder(strs[len-1]):new StringBuilder("");
        for (int i=strs.length-2; i>=0; i--) 
            ans.append(" "+strs[i]);
        
        return ans.toString();
    }
}