public class LC410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int[] sum = new int[nums.length+1];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++) sum[i] = sum[i-1]+nums[i];
        int[][] dp = new int[nums.length][m+1];
        dp[0][1] = nums[0];
        for(int i=1;i<dp.length;i++) dp[i][1] = dp[i-1][1]+nums[i];
        for(int i=1;i<dp.length;i++){
            for(int k=2;k<=Math.min(i+1, m);k++){
                dp[i][k] = Integer.MAX_VALUE;
                for(int j=1;j<=i-k+2;j++){
                    dp[i][k] = Math.min(dp[i][k], Math.max(sum[i]-sum[i-j], dp[i-j][k-1]));
                }
            }
        }
        return dp[nums.length-1][m];
    }
}
