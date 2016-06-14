public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] nums = new int[s.length()];
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.size()!=0) {
                    nums[stack.pop()] = 1;
                    nums[i] = 1;
                }
            }
        }
        
        int ans = 0;
        int len = 0;
        for (int i=0; i<s.length(); i++) {
            if (nums[i]==0) {
                ans = Math.max(ans, len);
                len = 0;
            } else {
                len ++;
            }
        }
        return Math.max(ans, len);  
    }
}