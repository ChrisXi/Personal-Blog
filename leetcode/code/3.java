public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int start = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int last = map.get(c);
                if (last >= start) {
                    start = last+1;
                } else {
                    ans = ans>(i-start+1) ? ans:(i-start+1);
                }
            } else {
                ans = ans>(i-start+1) ? ans:(i-start+1);
            }
            map.put(c, i);
        }
        
        return ans;
    }
}