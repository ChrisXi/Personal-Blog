public class Solution {
    public int jump(int[] nums) {
        
        int len = nums.length;
        int ans = 0;
        for (int i=0; i<len-1; ) {
            
            int maxIndex = 0;
            int nextIndex = i;
            for (int j=1; j<=nums[i]; j++) {
                if (i+j >= len-1) {
                    return ++ans;
                }
                
                if (maxIndex <= j+nums[i+j]) {
                    maxIndex = j+nums[i+j];
                    nextIndex = i+j;
                }
            }
            
            ans++;
            i = nextIndex;
        }
        
        return ans;
    }
}