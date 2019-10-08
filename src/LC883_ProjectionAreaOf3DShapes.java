public class LC883_ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;

        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                cnt += row[j] == 0 ? 0 : 1;
            }
        }

        for(int i = 0; i < m; i++) {
            int highest = 0;
            for(int j = 0; j < n; j++) {
                highest = Math.max(highest, grid[i][j]);
            }
            cnt += highest;
        }

        for(int j = 0; j < n; j++) {
            int highest = 0;
            for(int i = 0; i < m; i++) {
                highest = Math.max(highest, grid[i][j]);
            }
            cnt += highest;
        }

        return cnt;
    }
}
