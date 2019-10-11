public class LC887_SuperEggDrop {
    public int superEggDrop(int K, int N) {
        // dp[k][t] denotes that the max number of floors we can test with k eggs within t steps
        int[][] dp = new int[K + 1][N + 1];

        for(int t = 1; t <= N; t++) {
            for(int k = 1; k <= K; k++) {
                dp[k][t] = dp[k][t - 1] + dp[k - 1][t - 1] + 1;
                if(dp[k][t] >= N) return t;
            }
        }

        return N;
    }

    // dp solution O(KN^2)
//    public int superEggDrop(int K, int N) {
//        int[][] dp = new int[K + 1][N + 1];
//        for(int i = 1; i <= N; i++) dp[1][i] = i;
//
//        for(int k = 2; k <= K; k++) {
//            for(int j = 1; j <= N; j++) {
//                dp[k][j] = Integer.MAX_VALUE;
//                for(int i = j; i > 0; i--) {
//                    dp[k][j] = Math.min(dp[k][j], Math.max(dp[k - 1][i - 1], dp[k][j - i]) + 1);
//                }
//            }
//        }
//
//        return dp[K][N];
//    }
}
