public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i=0; i<strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String str = String.valueOf(cs);
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                List<String> lst = new ArrayList<String>();
                lst.add(strs[i]);
                ans.add(lst);
                map.put(str, lst);
            }
        }
        
        for (int i=0; i<ans.size(); i++) 
            Collections.sort(ans.get(i));
        
        return ans;  
    }
}