public class Solution {
    public int maxProfit(int[] prices) {
        int sell1, sell2, buy1, buy2;
        sell1 = sell2 = 0;
        buy1 = buy2 = Integer.MIN_VALUE;
        
        for (int i=0; i<prices.length; i++) {
            buy1  = Math.max(buy1,  -prices[i]);
            sell1 = Math.max(sell1, prices[i]+buy1);
            buy2  = Math.max(buy2,  -prices[i]+sell1);
            sell2 = Math.max(sell2, prices[i]+buy2);
        }
        
        return sell2;
    }
}