public class LC688_KnightProbabilityInChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for(int t = 0; t < K; t++) {
            double[][] dpNext = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] dir: directions) {
                        int prevR = i - dir[0];
                        int prevC = j - dir[1];
                        if(valid(prevR, prevC, N)) {
                            dpNext[i][j] += dp[prevR][prevC] * 0.125;
                        }
                    }
                }
            }

            dp = dpNext;
        }

        double res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }

    private boolean valid(int r, int c, int N) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
