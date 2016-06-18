public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new ArrayList<String>();
        if (words.length == 0)
            return ans;
    
        int len = 0;
        int s = 0, e = 0;
        int num = 0;
        while (e <= words.length) {
            
            if (e<words.length && len+words[e].length()+num <= maxWidth) {
                len += words[e].length();
                ++ e;
                ++ num;
            } else {
                StringBuilder str = new StringBuilder("");
                int n = num==1 ? 1:num-1;
                int allSpace = maxWidth-len;
                int eachSpace = allSpace/n;
                int remainSpace = allSpace-eachSpace*n;
                for (int j=s; j<e-1; j++) {
                    str.append(words[j]);
                    int space = (e>=words.length) ? 1:(eachSpace+(j-s<remainSpace ? 1:0));
                    appendStr(str, space);
                }
                str.append(words[e-1]);
                appendStr(str, maxWidth-str.length());
                
                ans.add(str.toString());
                
                s = e;
                num = 0;
                len = 0;
                
                if (e >= words.length)
                    return ans;
            }
        }
        
        return ans;
    }
    
    void appendStr(StringBuilder s, int n) {
        for (int i=1; i<=n; i++) 
            s.append(" ");
    }
    
} 