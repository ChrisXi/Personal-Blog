public class Solution {
    public int hIndex(int[] citations) {
        
        int len = citations.length;
        int s=0, e=len-1;
        
        while (s <= e) {
            int m = s+((e-s)>>1);
            
            if (citations[m] < len-m) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        
        return len-s;
        
    }
}