import java.util.HashSet;
import java.util.Set;

public class LC694_NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> shapes = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    String str = dfs(grid, i, j, 'S', visited);
                    shapes.add(str);
                }
            }
        }
        return shapes.size();
    }
    private String dfs(int[][] grid, int i, int j, char direc, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return "E";
        StringBuilder sb = new StringBuilder();
        sb.append(direc);
        visited[i][j] = true;
        sb.append(dfs(grid, i - 1, j, 'U', visited));
        sb.append(dfs(grid, i + 1, j, 'D', visited));
        sb.append(dfs(grid, i, j - 1, 'L', visited));
        sb.append(dfs(grid, i, j + 1, 'R', visited));
        return sb.toString();
    }
}
