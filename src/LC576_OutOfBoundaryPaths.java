public class LC576_OutOfBoundaryPaths {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int mod = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        if(N < 0) return 0;
        if(outOfBound(m, n, i, j)) return 1;

        int[][][] dp = new int[m][n][N+1];
        for(int k = 1; k <= N; k++){
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                    for(int[] direc: directions){
                        int rr = r + direc[0];
                        int cc = c + direc[1];
                        dp[r][c][k] += outOfBound(m, n, rr, cc) ? 1 : dp[rr][cc][k-1];
                        dp[r][c][k] %= mod;
                    }
                }
            }
        }

        return dp[i][j][N];
    }

    private boolean outOfBound(int m, int n, int i, int j){
        return i < 0 || i == m || j < 0 || j == n;
    }
}
