public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Set<String> ts = new HashSet<String>();
        
        for (int i=0; i<tickets.length; i++) {
            ts.add(tickets[i][0]);
            List<String> lst = map.getOrDefault(tickets[i][0], new ArrayList<String>());
            lst.add(tickets[i][1]);
            map.put(tickets[i][0], lst);
        }
        
        for (String t:ts) {
            List<String> lst = map.get(t);
            Collections.sort(lst, (s1, s2)->s1.compareTo(s2));
        }
        
        List<String> ans = new ArrayList<String>();
        search(ans, "JFK", map, tickets.length+1);
        
        return ans;
    }
    
    boolean search(List<String> ans, String s, Map<String, List<String>> map, int size) {
        
        List<String> lst = map.getOrDefault(s, new ArrayList<String>());
        ans.add(s);
        if (ans.size() == size)
            return true;
        
        for (int i=0; i<lst.size(); i++) {
            String str = lst.get(i);
            lst.remove(i);
            if (search(ans, str, map, size))
                return true;
            lst.add(i, str);
        }
        
        ans.remove(ans.size()-1);
        return false;
    }
}