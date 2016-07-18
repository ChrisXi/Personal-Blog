public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        
        int p1 = -1, p2 = -1, ans = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (word1.equals(word2) && p2 != -1)
                    ans = Math.min(ans, Math.abs(p1-p2));
            }
                
            if (words[i].equals(word2)) 
                p2 = i;
            
            if (!word1.equals(word2) && p1!=-1 && p2!=-1) 
                ans = Math.min(ans, Math.abs(p1-p2));
        }
        
        return ans;
    }
}