public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
       
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> list1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i+1));
                
                for (int l1 : list1) {
                    for (int l2 : list2) {
                        if (c == '+') 
                            ans.add(l1+l2);
                        if (c == '-')
                            ans.add(l1-l2);
                        if (c == '*')
                            ans.add(l1*l2);
                    }
                }
            }
        }
        
        if (ans.size() == 0) 
            ans.add(Integer.parseInt(input));
        
           
        return ans;
        
    }
}