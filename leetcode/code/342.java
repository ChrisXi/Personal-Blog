public class Solution {
    public boolean isPowerOfFour(int num) {
        
        String strNum = Integer.toBinaryString(num);
        String s = strNum.replace("00", "");
        if(s.equals("1")){
            return true;
        }
        
        return false;
    }
}