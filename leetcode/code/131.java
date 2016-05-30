public class Solution {
    
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        
        ans = new ArrayList<List<String>>();    
        getPalindrome(new ArrayList<String>(), s);
        
        return ans;
    }
    
    void getPalindrome(ArrayList<String> lst, String str) {
        
        if(str.length() == 0) {
            this.ans.add(new ArrayList<String>(lst));
            return;
        }
        
        for(int i=1; i<=str.length(); i++) {
            
            String t = str.substring(0, i);
            if(isPalindrome(t)) {
                lst.add(t);
                getPalindrome(lst, str.substring(i));
                lst.remove(lst.size()-1);
            }
        }    
    }
    
    boolean isPalindrome(String str) { //length of str >= 1
        int s=0, e=str.length()-1;
        
        do {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        } while (s<e);
        
        return true;
    }
}