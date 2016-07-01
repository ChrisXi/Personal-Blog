public class Solution {
    
    Stack<Integer> stack = new Stack<Integer>();
    public int calculate(String s) {
        
        int ans = 0;
        int n = 0, sign = 1;
    
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                n = calculate(s.substring(i+1));
                i += stack.pop();
            } else if (c == ')') {
                stack.push(i+1);
                return ans+sign*n;
            } else if (c == '+') {
                ans += sign*n;
                n = 0;
                sign = 1;
            } else if (c == '-') {
                ans += sign*n;
                n = 0;
                sign = -1;
            } else if (Character.isDigit(c)) {
                n = n*10 + (c-'0');
            }
        }
        
        return ans+sign*n;
    }
}