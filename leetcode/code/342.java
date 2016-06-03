public class Solution {
    public boolean isPowerOfFour(int num) {
        
        String strNum = Integer.toBinaryString(num);
        String s = strNum.replace("00", "");
        return s.equals("1");
    }
}