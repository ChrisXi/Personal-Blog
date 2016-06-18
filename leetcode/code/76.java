public class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> temp = new HashMap<Character, Integer>();
        
        int size = t.length();
        int count = 0;
        int last = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for (char c:t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        for (int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                
                temp.put(c, temp.getOrDefault(c, 0)+1);
                if (temp.get(c) <= map.get(c)) {
                    count ++;
                    if (count == size) {
                        if (i-last+1 < min) {
                            ans = s.substring(last, i+1);
                            min = i-last+1;
                        }
                            
                        while (count == size) {
                            char delc = s.charAt(last);
                            if (temp.containsKey(delc)) {
                                temp.put(delc, temp.get(delc)-1);
                                if (temp.get(delc) < map.get(delc)){
                                    last ++;
                                    count --;
                                    break;
                                }
                            }
                            last ++;
                            if (i-last+1 < min) {
                                ans = s.substring(last, i+1);
                                min = i-last+1;
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}