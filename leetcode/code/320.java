public class Solution {
    public List<String> generateAbbreviations(String word) {
        
        List<String> ans = new ArrayList<String>();
        getLst(ans, new StringBuilder(""), word, 0);
        
        return ans;
    }
    
    void getLst(List<String> ans, StringBuilder s, String str, int start) {
        if (start >= str.length()) {
            ans.add(s.toString());
            return;
        }
        
        for (int i=start; i<=str.length(); i++) {
            int templen = s.length();
            s.append(str.substring(start, i));
            if (i==str.length())
                ans.add(s.toString());
            for (int j=i; j<str.length(); j++) {
                int len = s.length();
                s.append(j-i+1);
                s.append(j+1<str.length() ? str.charAt(j+1):"");
                getLst(ans, s, str, j+2);
                s.setLength(len);
            }
            s.setLength(templen);
        }
         
    }
}