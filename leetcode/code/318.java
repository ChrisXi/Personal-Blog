public class Solution {
    public int maxProduct(String[] words) {
        
        int len = words.length;
        int[] val = new int[len];
        
        for (int i=0; i<len; i++) {
            for (char c:words[i].toCharArray()) {
                val[i] = val[i] | (1<<(c-'a'));
            }
        }
        
        int max = 0;
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if ((val[i] & val[j]) == 0) {
                    max = Math.max(words[i].length()*words[j].length(), max);
                }
            }
        }
        
        return max;
    }
}