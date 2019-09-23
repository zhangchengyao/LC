public class LC799_ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for(int r = 0; r < query_row; r++) {
            for(int j = 0; j <= r + 1; j++) {
                dp[r + 1][j] = j == 0 ? Math.max(0, (dp[r][j] - 1) / 2) : Math.max(0, (dp[r][j - 1] - 1) / 2) + Math.max(0, (dp[r][j] - 1) / 2);
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}
