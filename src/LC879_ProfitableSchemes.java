public class LC879_ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1_000_000_007;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;

        for(int c = 0; c < group.length; c++) {
            int g = group[c];
            int p = profit[c];

            for(int i = G; i >= g; i--) {
                for(int j = P; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)]) % mod;
                }
            }
        }

        int res = 0;
        for(int i = 0; i <= G; i++) {
            res += dp[i][P];
            res %= mod;
        }

        return res;
    }
}
