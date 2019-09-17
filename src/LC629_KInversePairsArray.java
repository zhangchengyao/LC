public class LC629_KInversePairsArray {
    public int kInversePairs(int n, int k) {
        if(k == 0) return 1;
        if(n < 2) return 0;

        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= Math.min(i * (i - 1) / 2, k); j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                if(j >= i) {
                    dp[i][j] = (dp[i][j] + mod - dp[i - 1][j - i]) % mod;
                }

                // for(int t = 0; t <= Math.min(j, i - 1); t++) {
                //     dp[i][j] = (dp[i][j] + dp[i - 1][j - t]) % mod;
                // }

                // 我们可以对上面的解法进行时间上的优化，还是来看我们的递推公式:
                // dp[n][k] = dp[n - 1][k] + dp[n - 1][k-1] + ... + dp[n - 1][k - n + 1]
                // 我们可以用k+1代替k，得到：
                // dp[n][k+1] = dp[n - 1][k+1] + dp[n - 1][k] + ... + dp[n - 1][k + 1 - n + 1]
                // 用第二个等式减去第一个等式可以得到：
                // dp[n][k+1] = dp[n][k] + dp[n - 1][k+1] - dp[n - 1][k - n + 1]
                // 将k+1换回成k，可以得到：
                // dp[n][k] = dp[n][k-1] + dp[n - 1][k] - dp[n - 1][k - n]
            }
        }

        return dp[n][k];
    }
}
