public class Solution {
    public int lengthLongestPath(String input) {
        
        Stack<Integer> stack = new Stack<Integer>();
        String[] strs = input.split("\n");
        
        int max = 0;
        for(String str:strs) {
            int level = getLevel(str);
            while(stack.size() > level) {
                stack.pop();
            }
            int len = (stack.size() !=0 ? stack.peek()+1:0) + removeTab(str).length(); 
            max = isFile(str) ? Math.max(max, len):max;
            stack.push(len);
        }
        
        return max;
    }
    
    int getLevel(String s) {
        return s.startsWith("\t") ? 1+getLevel(s.substring(1)):0;
    }
    
    String removeTab(String s) {
        return s.startsWith("\t") ? removeTab(s.substring(1)):s;
    }
    
    boolean isFile(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '.')
                return true;
        }
        return false;
    }
}