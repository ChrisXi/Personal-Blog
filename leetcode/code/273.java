public class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String[] levels = {"", "Thousand", "Million", "Billion"};
        int l = 0;
        String ans = "";
        
        while(num > 0) {
            if (num%1000 != 0)
                ans = get(num%1000).trim()+" "+levels[l]+" "+ans;
            num /= 1000;
            l++;
        }
        
        return ans.trim();
    }
    
    String get(int num) {
        String[] strs1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] strs2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        if (num >= 100) 
            return get(num/100)+"Hundred "+get(num%100)+" ";
        else if (num%100 >= 20) 
            return strs2[(num%100)/10]+" "+get(num%10)+" ";
        else if (num%100 > 0) 
            return strs1[num%100]+" ";
        else     
            return "";
    }
}