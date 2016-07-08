public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0, r = 0, ans = 0;
        
        while (r < s.length()) {
            
            if (map.size() == 2 && !map.containsKey(s.charAt(r))) {
                l = s.length();
                char key = ' ';
                for (char c : map.keySet()) {
                    key = map.get(c)<l ? c:key;
                    l = Math.min(l, map.get(c));
                }
                map.remove(key);
                l ++;
            } 
            
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r-l+1);
            r ++;
        }
        return ans;
    }
}