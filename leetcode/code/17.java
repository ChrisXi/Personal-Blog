public class Solution {
    public List<String> letterCombinations(String digits) {
        
        char[][] letters = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
        List<String> ans = new ArrayList<String>();
        
        if (digits.length() == 0) return ans;
        
        add(ans, new StringBuilder(""), digits, letters);
        return ans;
    }
    
    public void add(List<String> ans, StringBuilder temp, String digits, char[][] letters) {
        
        if (digits.length() == 0) {
            ans.add(temp.toString());
            return;
        }
        
        int index = digits.charAt(0)-'2';
        for (int i=0; i<letters[index].length; i++) {
            temp.append(letters[index][i]);
            add(ans, temp, digits.substring(1), letters);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
}