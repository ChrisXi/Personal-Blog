public class Solution {
    
    public int totalNQueens(int n) {

        boolean[] used2 = new boolean[n];
        boolean[] used3 = new boolean[2*n-1];
        boolean[] used4 = new boolean[2*n-1];
        
        int ans = check(n, n, used2, used3, used4);
        
        return ans;
    }
    
    int check(int len, int n, boolean[] used2, boolean[] used3, boolean[] used4) {
        int ans = 0;
        int i = len-n;
        for (int j=0; j<len; j++) {
            
            if (!(used2[j] || used3[i+j] || used4[i+len-1-j])) {
                
                used2[j] = used3[i+j] = used4[i+len-1-j] = true;    
                
                if (n-1 == 0) {
                    used2[j] = used3[i+j] = used4[i+len-1-j] = false;    
                    return 1;
                }
                else ans += check(len, n-1, used2, used3, used4);
                
                used2[j] = used3[i+j] = used4[i+len-1-j] = false;    
            }
        }
        return ans;
    }
}