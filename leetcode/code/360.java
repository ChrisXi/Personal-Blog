public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        int[] ans = new int[nums.length];
        int p = (a>=0 ? nums.length-1:0); 
        int p1 = 0, p2 = nums.length-1;
        
        while (p1 <= p2) {
            int n1 = ans(a, b, c, nums[p1]);
            int n2 = ans(a, b, c, nums[p2]);
            
            if (a >= 0) 
                ans[p] = n1 > n2 ? ans(a, b, c, nums[p1++]):ans(a, b, c, nums[p2--]);
            else 
                ans[p] = n1 < n2 ? ans(a, b, c, nums[p1++]):ans(a, b, c, nums[p2--]);
            
            p += (a>=0 ? -1:1);
        }
        return ans;
    }
    
    int ans(int a, int b, int c, int x) {
        return a*x*x+b*x+c;
    }
}