public class Solution {
    
    int[] nt;
    public int numTrees(int n) {
        
        nt = new int[n+1];
        nt[0] = 1;
        nt[1] = 1;
        
        return getNum(n);
    }
    
    int getNum(int n) {
        
        if(nt[n] != 0) {return nt[n];}
        
        int ans = 0;
        n --;
        for(int i=0; i<=n; i++) {
            ans += (getNum(i)*getNum(n-i));
        }
        nt[n+1] = ans;
          
        return ans;
    }
}  