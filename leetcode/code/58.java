public class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] strs = s.trim().split("\\s+");
        return strs.length==0 ? 0:strs[strs.length-1].length();
    }
}