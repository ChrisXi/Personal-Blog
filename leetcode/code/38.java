public class Solution {
    public String countAndSay(int n) {
        
        String str = "1";
        
        while (n-- > 1) {
            StringBuilder temp = new StringBuilder("");
            int count = 0;
            char last = str.charAt(0);
            for (char c : str.toCharArray()) {
                if (c == last) {
                    count ++;
                } else {
                    temp.append(count+""+last);
                    count = 1;
                    last = c;
                }
            }
            temp.append(count+""+last);
            str = temp.toString();
        }  
        
        return str;
    }
}