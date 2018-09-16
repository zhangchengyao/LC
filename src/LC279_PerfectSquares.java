public class LC279_PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;i-j*j>=0;j++){
                if(dp[i]==0) dp[i] = dp[i-j*j]+1;
                else dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
