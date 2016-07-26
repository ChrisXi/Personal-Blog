public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str:strings) {
            char[] cs = str.toCharArray();
            String key = "";
            if (cs.length == 0) {
                key = str;
            } else {
                for (int i=1; i<cs.length; i++) 
                    cs[i] = (char)(cs[i]-(cs[0]-'a') < 'a'? cs[i]-(cs[0]-'a')+26 : cs[i]-(cs[0]-'a'));
                cs[0] = 'a';
                key = String.valueOf(cs);
            }
            List<String> lst = map.getOrDefault(key, new ArrayList<String>());
            lst.add(str);
            map.putIfAbsent(key, lst);
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        for (String key:map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
}