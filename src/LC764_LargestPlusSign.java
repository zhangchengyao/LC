import java.util.HashSet;
import java.util.Set;

public class LC764_LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        for(int[] mine: mines) {
            banned.add(mine[0] * N + mine[1]);
        }

        int[][] dp = new int[N][N];
        int res = 0;
        for(int r = 0; r < N; r++) {
            int count = 0;
            for(int c = 0; c < N; c++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for(int c = N - 1; c >= 0; c--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for(int c = 0; c < N; c++) {
            int count = 0;
            for(int r = 0; r < N; r++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for(int r = N - 1; r >= 0; r--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                res = Math.max(res, dp[r][c]);
            }
        }

        return res;
    }
}
