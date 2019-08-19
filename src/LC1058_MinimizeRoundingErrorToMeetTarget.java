import java.util.HashMap;

public class LC1058_MinimizeRoundingErrorToMeetTarget {
    // todo
    public String minimizeError(String[] prices, int target) {
        int n = prices.length;
        HashMap<Double, Double>[] dp = new HashMap[n];
        double floor = Math.floor(Double.parseDouble(prices[0]));
        double ceil = Math.ceil(Double.parseDouble(prices[0]));
        dp[0] = new HashMap<>();
        dp[0].put(floor, Math.abs(floor - Double.parseDouble(prices[0])));
        dp[0].put(ceil, Math.min(dp[0].getOrDefault(ceil, (double)Integer.MAX_VALUE), Math.abs(ceil - Double.parseDouble(prices[0]))));

        for(int i = 1; i < n; i++) {
            double value = Double.parseDouble(prices[i]);
            dp[i] = new HashMap<>();
            for(double sum: dp[i - 1].keySet()) {
                floor = Math.floor(value) + sum;
                ceil = Math.ceil(value) + sum;
                double error = dp[i - 1].get(sum);
                dp[i].put(floor, Math.min(dp[i].getOrDefault(floor, (double)Integer.MAX_VALUE), error + Math.abs(floor - sum -value)));
                dp[i].put(ceil, Math.min(dp[i].getOrDefault(ceil, (double)Integer.MAX_VALUE), error + Math.abs(ceil - sum - value)));
            }
        }

        if(!dp[n - 1].containsKey((double)target)) return "-1";

        return String.format("%.3f", dp[n - 1].get((double)target));
    }
}
