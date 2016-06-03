public class Solution {
    public boolean isPowerOfTwo(int n) {
        
        String strNum = Integer.toBinaryString(n);
        String s = strNum.replace("0", "");
        if(s.equals("1") && n >= 0){
            return true;
        }
        
        return false;

        /*
        if(n <= 0)
            return false;
            
        return (n & (n-1)) == 0;
        */
    }
}