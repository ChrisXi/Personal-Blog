public class Solution {
    public String multiply(String num1, String num2) {
        int len = (num1.length()+1)+(num2.length()+1);
        int[] num = new int[len];
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        for (int i=0; i<num1.length(); i++) 
            for (int j=0; j<num2.length(); j++) 
                num[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        
        for (int i=0; i<len-1; i++) {
            num[i+1] += num[i]/10;
            num[i] %= 10;
        }    
        
        StringBuilder ans = new StringBuilder("");
        for (int i=len-1; i>=0; i--) {
            if (!(ans.length() == 0 && num[i] == 0)) 
                ans.append(num[i]);
        }
        
        return ans.length()==0 ? "0":ans.toString();
            
        
    }
}