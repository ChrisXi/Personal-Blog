public class Solution {
    
    private int low=0, high=0;
    public String longestPalindrome(String s) {
        
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            max = checkPalindrome(s, i, i, max);
            max = checkPalindrome(s, i, i+1, max); 
        }
        
        return s.substring(low, high+1);
    }
    
    private int checkPalindrome(String s, int p1, int p2, int max) {
        
        if (0>p1 || p2>=s.length() || s.charAt(p1)!=s.charAt(p2))
            return Math.max(max, 0);
        
        while (0<=p1 && p2<s.length() && s.charAt(p1)==s.charAt(p2)) {
            p1 --;
            p2 ++;
        }
        
        int len = (--p2)-(++p1);
        
        if (len >= max) {
            low = p1;
            high = p2;
            return len;
        }
        
        return max;
    }
}

/* Manacher's Algorithm */
public class Solution {
    public String longestPalindrome(String s) {
        
        s = "@"+s.replace("", "$")+"&";
        int[] palin = new int[s.length()];
        
        int c = 1, r = 1, max = 0, ans = 0;
        for (int i=1; i<s.length()-1; i++) {
            int mir = 2*c - r; // c-(r-c);
            
            if (i < r) 
                palin[i] = Math.min(r-i, palin[mir]);
            
            while (s.charAt(i+palin[i]+1) == s.charAt(i-palin[i]-1)) {
                palin[i] ++;
            }
            
            if (i+palin[i] > r) {
                c = i;
                r = i+palin[i]; 
            }
            
            ans = (max<palin[i] ? i:ans);
            max = Math.max(max, palin[i]);
        }
        
        return s.substring(ans-(palin[ans]-1), ans+(palin[ans]-1)+1).replace("$", "");
    }
}