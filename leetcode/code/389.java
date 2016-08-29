public class Solution {
    public char findTheDifference(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        char ans = c2[c2.length-1];
        for (int i=0; i<c1.length+c2.length-1; i++) 
            ans ^= (i<c1.length ? c1[i]:c2[i-c1.length]);
            
        return ans;
    }
}