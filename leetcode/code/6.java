public class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows <= 1) 
            return s;
        
        StringBuilder[] strs = new StringBuilder[numRows];
        
        for (int i=0; i<numRows; i++) 
            strs[i] = new StringBuilder("");
            
        int index=0;
        int incre=1;
        for (int i=0; i<s.length(); i++) {
            strs[index].append(s.charAt(i));
            if (index == numRows-1) incre = -1;
            if (index == 0) incre = 1;
            index += incre;
        }
        
        StringBuilder ans = new StringBuilder("");
        for (int i=0; i<numRows; i++) 
            ans.append(strs[i]);
            
        return ans.toString();
        
        
    }
}