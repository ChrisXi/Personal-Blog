public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int p1=-1, p2=-1, ans = Integer.MAX_VALUE;
        
        for (int i=0; i<words.length; i++) {
            
            if (word1.equals(words[i]))
                p1 = i;
            
            if (word2.equals(words[i]))
                p2 = i;
            
            ans = (p1==-1 || p2==-1 ? ans:Math.min(ans, Math.abs(p1-p2)));
        }
         
        return ans;
    }
}   