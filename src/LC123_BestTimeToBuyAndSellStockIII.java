public class LC123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int lowest = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>lowest){
                maxProfit = Math.max(maxProfit, prices[i]-lowest);
            }
            left[i] = maxProfit;
            lowest = Math.min(lowest, prices[i]);
        }
        int highest = prices[prices.length-1];
        maxProfit = 0;
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]<highest){
                maxProfit = Math.max(maxProfit, highest-prices[i]);
            }
            right[i] = maxProfit;
            highest = Math.max(highest, prices[i]);
        }
        maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(left[i]+right[i]>maxProfit) maxProfit = left[i]+right[i];
        }
        return maxProfit;
    }
}
