public class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        add(ans, new ArrayList<String>(), s);
        
        return ans;
    }
    
    void add(List<List<String>> ans, List<String> lst, String s) {
        
        if (s.length() == 0) {
            ans.add(new ArrayList<String>(lst));
            return;
        }
        
        for (int i=0; i<s.length(); i++) {
            String str = s.substring(0, i+1);
            if (isPalindrome(str)) {
                lst.add(str);
                add(ans, lst, s.substring(i+1));
                lst.remove(lst.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String str) {
        
        int s=0, e=str.length()-1;
        
        while(s < e) {
            if (str.charAt(s++) != str.charAt(e--))
                return false;
        }
        return true;
    }
}