import java.util.Arrays;

public class LC778_SwimInRisingWater {
    // todo: binary search
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] dp;

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        swim(grid, 0, 0, 0);

        return dp[n - 1][n - 1];
    }

    private void swim(int[][] grid, int r, int c, int curMax) {
        int n = grid[0].length;

        if(invalid(n, r, c) || curMax >= dp[r][c]) return ;

        curMax = Math.max(curMax, grid[r][c]);
        dp[r][c] = Math.min(dp[r][c], curMax);
        for(int[] dir: directions) {
            swim(grid, r + dir[0], c + dir[1], curMax);
        }
    }

    private boolean invalid(int n, int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}
