public class LC309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], buy[0]);
        sell[1] = Math.max(0, prices[1]-prices[0]);
        for(int i=2;i<prices.length;i++){
            buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
        }
        return Math.max(0, sell[prices.length-1]);
    }
}
