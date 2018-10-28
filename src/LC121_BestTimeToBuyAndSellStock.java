public class LC121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int max_profit = 0;
        int lowest = prices[0];
        for(int i=1;i<prices.length;i++){
            if(lowest<prices[i]){
                int profit = prices[i]-lowest;
                max_profit = Math.max(max_profit, profit);
            }
            lowest = Math.min(lowest, prices[i]);
        }
        return max_profit;
    }
}
