public class Solution {
    public List<String> generatePalindromes(String s) {
        
        List<String> ans = new ArrayList<String>();
        
        int[] cs = new int[256];
        int single = 0;
        
        for (char c:s.toCharArray()) {
            cs[c]++;
            single += (cs[c]%2 == 1 ? 1:-1);
        }
        if (single > 1) return ans;
        
        String sc = "";
        List<Character> lst = new ArrayList<Character>();
        for (int i=0; i<256; i++) {
            sc = (cs[i]%2 == 1 ? (char)(i)+"":sc);
            for (int j=1; j<=cs[i]/2; j++) {
                char c = (char)(i);
                lst.add(c);
            }
        }
        
        get(ans, lst, new StringBuilder(), sc);
        
        return ans;
    }
    
    void get(List<String> ans, List<Character> lst, StringBuilder str, String sc) {
        
        if (lst.size() == 0) {
            ans.add(str.toString()+sc+new StringBuilder(str).reverse().toString());
            return;
        }
        
        for (int i=0; i<lst.size();) {
            char c = lst.get(i);
            lst.remove(i);
            str.append(c);
            get(ans, lst, str, sc);
            str.setLength(str.length()-1);
            lst.add(i, c);
            i++;
            while (i < lst.size() && lst.get(i) == c) i++;
        }
    }
}