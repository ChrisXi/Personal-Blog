public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] ans = new int[length];
        for (int i=0; i<updates.length; i++) {
            int s = updates[i][0], e = updates[i][1], n = updates[i][2];
            ans[s] += n;
            if (e+1 < length)
                ans[e+1] -= n;
        }
        
        for (int i=1; i<length; i++) 
            ans[i] = ans[i-1]+ans[i];
        
        return ans;
    }
}