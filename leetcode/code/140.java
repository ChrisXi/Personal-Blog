public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        
        return search(s, 0, wordDict, new HashMap<Integer, List<String>>());
    }
    
    List<String> search(String s, int start, Set<String> wordDict, Map<Integer, List<String>> map) {
        
        if (map.containsKey(start)) 
            return map.get(start);
        
        List<String> ans = new ArrayList<String>();
        
        for (int i=s.length(); i>= start; i--) {
            String str = s.substring(start, i);
            if (wordDict.contains(str)) {
                
                if (i == s.length())
                    ans.add(str);
                else {
                    List<String> strs = search(s, i, wordDict, map);
                    for (String substr:strs) 
                        ans.add(str+" "+substr);
                }
            }
        }
        
        map.put(start, ans);
        
        return ans;
    }
}