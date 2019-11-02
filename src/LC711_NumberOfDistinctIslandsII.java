import java.util.*;

public class LC711_NumberOfDistinctIslandsII {
    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Set<String> islands = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(grid, i, j, visited, shape);
                    addShape(shape, islands, n);
                }
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, List<Integer> shape) {
        if(valid(grid, i, j) && !visited[i][j] && grid[i][j] == 1) {
            visited[i][j] = true;
            int n = grid[0].length;
            shape.add(i * n + j);
            dfs(grid, i - 1, j, visited, shape);
            dfs(grid, i + 1, j, visited, shape);
            dfs(grid, i, j - 1, visited, shape);
            dfs(grid, i, j + 1, visited, shape);
        }
    }

    private void addShape(List<Integer> shape, Set<String> islands, int n) {
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];
        int[] pos = new int[shape.size()];

        String canonical = "";
        for(int i = 0; i < 8; i++) {
            int t = 0;
            for(int idx: shape) {
                int r = idx / n;
                int c = idx % n;
                // x y, x -y, -x y, -x -y,
                // y x, y -x, -y x, -y -x
                xs[t] = i < 2 ? r : i < 4 ? -r : i < 6 ? c : -c;
                ys[t++] = i < 4 ? (i % 2 == 0 ? c : -c) : i % 2 == 0 ? r : -r;
            }

            int minX = xs[0];
            int minY = ys[0];
            for(int x: xs) minX = Math.min(minX, x);
            for(int y: ys) minY = Math.min(minY, y);

            for(int j = 0; j < xs.length; j++) {
                pos[j] = (xs[j] - minX) * n + ys[j] - minY;
            }

            Arrays.sort(pos);
            String cand = Arrays.toString(pos);
            if(canonical.compareTo(cand) < 0) canonical = cand;
        }

        islands.add(canonical);
    }

    private boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
