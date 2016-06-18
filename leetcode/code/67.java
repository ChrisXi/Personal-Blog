public class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder ans = new StringBuilder("");
        
        int i=a.length()-1, j=b.length()-1, carry=0;
        while(i>=0 || j>=0) {
            int n1 = i>=0 ? (int)(a.charAt(i)-'0'):0;
            int n2 = j>=0 ? (int)(b.charAt(j)-'0'):0;
            
            int sum = n1+n2+carry;
            ans.insert(0, sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        
        ans = (carry==1 ? ans.insert(0, "1"):ans);
        return ans.toString();
    }
}