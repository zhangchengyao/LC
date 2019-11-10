public class LC695_MaxAreaOfIsland {
    // a faster solution
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int res = 1;
        if(i > 0 && grid[i - 1][j] == 1) {
            res += getArea(grid, i - 1, j);
        }
        if(i < grid.length - 1 && grid[i + 1][j] == 1) {
            res += getArea(grid, i + 1, j);
        }
        if(j > 0 && grid[i][j - 1] == 1) {
            res += getArea(grid, i, j - 1);
        }
        if(j < grid[0].length - 1 && grid[i][j + 1] == 1 ){
            res += getArea(grid, i, j + 1);
        }
        return res;
    }
}
