public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        List<String> ans = new ArrayList<String>();
        
        if(s.length() < 10) 
            return ans;
        
        for(int i=0; i<=s.length()-10; i++) {
            String str = s.substring(i, i+10);
            int n = map.getOrDefault(str, 0);
            if(n == 1) {
                ans.add(str);
            } 
            map.put(str, n+1);
        }
        
        return ans;
    }
}