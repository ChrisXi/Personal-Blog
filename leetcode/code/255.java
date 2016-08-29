public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) 
            return true;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(preorder[0]);
        int min = Integer.MIN_VALUE;
        for (int i=1; i<preorder.length; i++) {
            int num = preorder[i];
            if (num < stack.peek()) {
                if (num < min) return false;
                stack.push(num);
            }
            else {
                while (stack.size() > 0 && num > stack.peek()) {
                    min = stack.pop();
                }
                stack.push(num);
            }
        }
        
        return true;
    }
}