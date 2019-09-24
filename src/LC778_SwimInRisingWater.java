import java.util.*;

public class LC778_SwimInRisingWater {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int left = 0;
        int right = n * n - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canReach(grid, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private boolean canReach(int[][] grid, int waterDepth) {
        if(grid[0][0] > waterDepth) return false;

        int n = grid.length;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / n;
            int c = cur % n;
            if(r == n - 1 && c == n - 1) return true;
            for(int[] dir: directions) {
                int val = (r + dir[0]) * n + c + dir[1];
                if(isValid(n, r + dir[0], c + dir[1]) && !visited.contains(val) && grid[r + dir[0]][c + dir[1]] <= waterDepth) {
                    q.offer(val);
                    visited.add(val);
                }
            }
        }

        return false;
    }

    private boolean isValid(int n, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

//    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    private int[][] dp;
//
//    public int swimInWater(int[][] grid) {
//        int n = grid.length;
//        dp = new int[n][n];
//        for(int[] row: dp) {
//            Arrays.fill(row, Integer.MAX_VALUE);
//        }
//
//        swim(grid, 0, 0, 0);
//
//        return dp[n - 1][n - 1];
//    }
//
//    private void swim(int[][] grid, int r, int c, int curMax) {
//        int n = grid[0].length;
//
//        if(invalid(n, r, c) || curMax >= dp[r][c]) return ;
//
//        curMax = Math.max(curMax, grid[r][c]);
//        dp[r][c] = Math.min(dp[r][c], curMax);
//        for(int[] dir: directions) {
//            swim(grid, r + dir[0], c + dir[1], curMax);
//        }
//    }
//
//    private boolean invalid(int n, int r, int c) {
//        return r < 0 || r >= n || c < 0 || c >= n;
//    }
}
