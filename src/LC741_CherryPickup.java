import java.util.Arrays;

public class LC741_CherryPickup {
    private int[][][] memo;

    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        memo = new int[N][N][N];
        for(int[][] layer: memo) {
            for(int[] row: layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, pick(grid, 0, 0, 0));
    }

    private int pick(int[][] grid, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;

        if(invalid(grid, r1, c1) || invalid(grid, r2, c2)) {
            return Integer.MIN_VALUE;
        } else if(r1 == grid.length - 1 && c1 == grid.length - 1) {
            return grid[r1][c1];
        } else if(memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        } else {
            int res = grid[r1][c1];
            if(c1 != c2) res += grid[r2][c2];
            res += Math.max(Math.max(pick(grid, r1 + 1, c1, c2), pick(grid, r1 + 1, c1, c2 + 1)), Math.max(pick(grid, r1, c1 + 1, c2 + 1), pick(grid, r1, c1 + 1, c2)));
            memo[r1][c1][c2] = res;
            return res;
        }
    }

    private boolean invalid(int[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1;
    }
}
