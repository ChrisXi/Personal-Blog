public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int wlen = words[0].length();
        int alen = words.length*wlen;
        
        for (int i=0; i<words.length; i++) 
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        
        for (int i=0; i<wlen; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>();    
            int start = i;
            
            if (start + alen > s.length())
                break;
                
            for (int j=i; j<=s.length()-wlen; j+=wlen) {
                
                String str = s.substring(j, j+wlen);
                
                if (!map.containsKey(str)) {
                    temp.clear();
                    start = j+wlen;
                    continue;
                }
                
                if (temp.getOrDefault(str, 0) < map.get(str)) {
                    temp.put(str, temp.getOrDefault(str, 0)+1);
                    if (start+alen == j+wlen) {
                        ans.add(start);
                        temp.put(s.substring(start, start+wlen), temp.get(s.substring(start, start+wlen))-1);
                        start = start+wlen;
                    }
                } else {
                    String curStr = "";
                    do {
                        curStr = s.substring(start, start+wlen);
                        start = start+wlen;
                        if (curStr.equals(str)) 
                        	break;
                        temp.put(curStr, temp.get(curStr)-1);
                    } while (true);
                }
                
                if (start + alen > s.length())
                    break;
            }
        }
        
        return ans;
    }
}