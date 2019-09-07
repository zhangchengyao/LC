import java.util.Arrays;

public class LC1066_CampusBikesII {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;

        int[][] dp = new int[n][1 << m];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i = 0; i < m; i++) {
            dp[0][1 << i] = dist(workers[0], bikes[i]);
        }

        for(int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j < m; j++) {
                for(int prev = 0; prev < dp[0].length; prev++) {
                    if(dp[i - 1][prev] != Integer.MAX_VALUE && (prev & (1 << j)) == 0) {
                        dp[i][prev | (1 << j)] = Math.min(dp[i][prev | (1 << j)], dp[i - 1][prev] + dist(workers[i], bikes[j]));
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < dp[0].length; j++) {
            if(dp[n - 1][j] != Integer.MAX_VALUE) {
                res = Math.min(res, dp[n - 1][j]);
            }
        }

        return res;
    }

    private int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
