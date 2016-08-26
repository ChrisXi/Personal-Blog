public class Solution {
    public int firstUniqChar(String s) {
        int[] cs = new int[26];
        Arrays.fill(cs, -2);
        for(int i=0; i<s.length(); i++) 
            cs[s.charAt(i)-'a'] = (cs[s.charAt(i)-'a']>=-1 ? -1:i);
        int ans = s.length();
        for(int i=0; i<26; i++) 
            ans = cs[i]>=0 ? Math.min(ans, cs[i]):ans;
    
        return ans==s.length() ? -1:ans;
    }
}