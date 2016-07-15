public class Solution {
    public void reverseWords(char[] s) {
        
        reverse(s, 0, s.length-1);
        
        int start = 0;
        for (int i=0; i<s.length; i++) {
            if (s[i] == ' ' || i == s.length-1) {
                reverse(s, start, i==s.length-1 ? i:i-1);
                start = i+1;
            }
        }
        
    }
    
    
    void reverse(char[] str, int s, int e) {
        while(s < e) {
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s ++;
            e --;
        }     
    }
}