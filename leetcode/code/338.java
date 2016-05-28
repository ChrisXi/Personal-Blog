public class Solution {
    public int[] countBits(int num) {
        
        int[] ans = new int[num+1];
        ans[0] = 0;
        
        if(num == 0) 
            return ans;
        
        ans[1] = 1;
        
        int bit = 2;
        while(true) {
    
            int len = (int)Math.pow(2,bit-1);
            for(int i=0; i<len; i++) {
                if(i+len>num) 
                    return ans;
                    
                ans[i+len]=ans[i]+1;
            }
            bit ++;
        }
        
    }
}