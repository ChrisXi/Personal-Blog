public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) 
            map.put(words[i], i);
        
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            
            for (int j=0; j<=word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);
                
                if (isPalindrom(str1)) {
                    String reStr = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(reStr) && map.get(reStr) != i) 
                        ans.add(Arrays.asList(new Integer[]{map.get(reStr), i}));
                }
                
                if (str2.length() != 0 && isPalindrom(str2)) {
                    String reStr = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(reStr) && map.get(reStr) != i) 
                        ans.add(Arrays.asList(new Integer[]{i, map.get(reStr)}));
                }
            }
        }
        
        return ans;
    }
    
    boolean isPalindrom(String s) {
        int l=0, r=s.length()-1;
        while(l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}