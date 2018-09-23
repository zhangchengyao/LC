public class LC746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+2];
        dp[1] = cost[0];
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + (i==dp.length-1?0:cost[i-1]);
        }
        return dp[cost.length+1];
    }
}
