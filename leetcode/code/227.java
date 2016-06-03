public class Solution {
    public int calculate(String s) {
        int pre = 0, op = 0, num=0, sign = 1, curr = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10+(c-'0');
                if (i == s.length()-1 || !Character.isDigit(s.charAt(i+1))) {
                    if(op == 0) {
                        curr = num;
                    } else {
                        curr = op==1 ? curr*num:curr/num;
                    }
                }
            } else {
                if (c == '*' || c == '/') {
                    op = c=='*' ? 1:-1;    
                    num = 0;
                } else if (c == '+' || c == '-') {
                    pre += sign*curr;
                    sign = c=='+' ? 1:-1;
                    num = 0;
                    op = 0;
                }
            }
        }
        
        return pre + sign*curr;
    }
}