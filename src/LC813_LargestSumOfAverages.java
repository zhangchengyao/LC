public class LC813_LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length][K + 1];

        int[] sum = new int[A.length + 1];
        for(int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        for(int i = 0; i < A.length; i++) {
            dp[i][1] = (sum[i + 1] - sum[0]) * 1.0 / (i + 1);
        }

        for(int i = 1; i < A.length; i++) {
            for(int k = 2; k <= Math.min(i + 1, K); k++) {
                for(int j = k - 1; j <= i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j - 1][k - 1] + (sum[i + 1] - sum[j]) * 1.0 / (i - j + 1));
                }
            }
        }

        return dp[A.length - 1][K];
    }
}
