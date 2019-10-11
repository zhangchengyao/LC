public class LC892_SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int area = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                area += 2;
                for(int[] direction: directions) {
                    if(valid(m, n, i + direction[0], j + direction[1])) {
                        area += Math.max(0, grid[i][j] - grid[i + direction[0]][j + direction[1]]);
                    } else {
                        area += grid[i][j];
                    }
                }
            }
        }

        return area;
    }

    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
