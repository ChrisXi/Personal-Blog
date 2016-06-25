public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] check = new boolean[len];
        
        for (int i=0; i<len; i++) {
            for (int j=len; j>i; j--) {
                if (wordDict.contains(s.substring(i, j))) {
                    check[j-1] = (i==0 ? true:check[j-1]||check[i-1]);
                }
            }
        }
        
        return check[len-1];
    }
}    