public class LC714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2) return 0;
        int buy = -prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }

        return sell;
    }

//    public int maxProfit(int[] prices, int fee) {
//        if(prices.length < 2) return 0;
//        int[] buy = new int[prices.length + 1];
//        int[] sell = new int[prices.length + 1];
//        buy[1] = -prices[0];
//        for(int i = 2; i < buy.length; i++) {
//            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1] - fee);
//            buy[i] = Math.max(buy[i - 1], sell[i] - prices[i - 1]);
//        }
//        return sell[prices.length];
//    }
}
