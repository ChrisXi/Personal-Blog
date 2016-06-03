public class Solution {
    public int hIndex(int[] citations) {
        
        int len = citations.length;
        int[] ans = new int[len+1];
        
        for (int n : citations) {
            if (n > len) {
                ans[len] += 1;
            } else {
                ans[n] += 1;
            }
        }
        
        for (int i=len; i>=0; i--) {
            if (i < len)
                ans[i] += ans[i+1];
            
            if (i <= ans[i])
                return i;
        }
        
        return 0;
    }
}  