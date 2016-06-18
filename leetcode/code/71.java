public class Solution {
    public String simplifyPath(String path) {
        
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for (int i=1; i<strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals("")) {
                continue;
            } else if (strs[i].equals("..")) {
                if(stack.size() != 0) 
                    stack.pop();
            } else {
                stack.push(strs[i]);
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        while(stack.size() != 0) {
            ans.insert(0, "/"+stack.pop());
        }
        
        return ans.length()==0 ? "/":ans.toString();
        
    }
}