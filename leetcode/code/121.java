public class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE, ans = 0;
        
        for (int i=0; i<prices.length; i++) {
            min = Math.min(prices[i], min);
            ans = Math.max(prices[i]-min, ans);
        }
        
        return ans;
    }
}