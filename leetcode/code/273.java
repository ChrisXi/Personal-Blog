public class Solution {
    public String numberToWords(int num) {

        String ans = "";
        String str = new StringBuilder(num+"").reverse().toString();
        String[] levels = {" ", "Thousand", "Million", "Billion"};
        
        int s = 0, l = 0;
        
        while (s < str.length()) {
            int e = s+Math.min(str.length()-s, 3);
            String n = str.substring(s, e);
            if (n.equals("000") && str.length()-e>=1) {
                l ++;
            } else {
                ans = getNum(n) + " " + levels[l++] + ans;    
            }
            
            s = e;
        }
        
        return ans.trim();
    }
    
    String getNum(String nums) {
        String[] strs1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"}; 
        String[] strs2 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] strs3 = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen"};
        
        String ans = "";
        if (nums.length() == 3 && nums.charAt(2) != '0') 
            ans = ans + " " +strs1[(nums.charAt(2)-'0')] + " Hundred";
        
        if (nums.length() >= 2 && nums.charAt(1) != '0') {
            if (nums.charAt(1) == '1' && nums.charAt(0) != '0')
                ans = ans + " " + strs3[(nums.charAt(0)-'1')];
            else {
                ans = ans + " " + strs2[(nums.charAt(1)-'0')];
                if (nums.charAt(0) != '0')
                    ans = ans + " " + strs1[(nums.charAt(0)-'0')];    
            }
        }
        
        if ((nums.length() >= 2 && nums.charAt(1) == '0' && nums.charAt(0) != '0') || nums.length() == 1) 
            ans = ans + " " + strs1[(nums.charAt(0)-'0')];    
        
        return ans;
    }
}