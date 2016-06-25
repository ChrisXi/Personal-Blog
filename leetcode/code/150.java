public class Solution {
    public int evalRPN(String[] tokens) {
        
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String str:tokens) {
            if (str.equals("-") || str.equals("*") || str.equals("+") || str.equals("/")){
                int n2 = stack.pop(), n1 = stack.pop();
                stack.push(get(str, n1, n2));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
    
    int get(String str, int i1, int i2) {
        if (str.equals("-")) {
            return i1-i2;
        } else if (str.equals("*")) {
            return i1*i2;
        } else if (str.equals("+")) {
            return i1+i2;
        } else if (str.equals("/")) {
            return i1/i2;
        }
        
        return 0;
    }
}