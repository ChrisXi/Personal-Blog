public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int ans = 0;
        for (int i=0; i<32; i++) {
            ans |= ((((1<<i) & n) >>> i) << (31-i));
        }
        return ans;
    }
}