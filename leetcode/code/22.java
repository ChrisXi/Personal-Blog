public class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<String>();
        
        add(ans, new StringBuilder(""), n, 0);
        return ans;
    }
    
    void add(List<String> ans, StringBuilder s, int n, int left) {
        StringBuilder str = new StringBuilder(s);
        str.append('(');
        
        if (n == 1) {
            for (int i=1; i<=left+1; i++)
                str.append(')');
            ans.add(str.toString());
            return;
        }
        
        add(ans, str, n-1, left+1);
        for (int i=1; i<=left+1; i++) 
            add(ans, str.append(')'), n-1, left+1-i);
    }
}