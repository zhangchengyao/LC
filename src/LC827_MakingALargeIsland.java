import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC827_MakingALargeIsland {
    private int n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid) {
        n = grid.length;

        Set<Integer> visited = new HashSet<>();
        int[] parent = new int[2600];
        Map<Integer, Integer> sizes = new HashMap<>();

        for(int i = 0; i < parent.length; i++) parent[i] = i;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int pos = i * n + j;
                if(grid[i][j] == 1 && !visited.contains(pos)) {
                    int size = dfs(grid, i, j, pos, parent, visited);
                    sizes.put(pos, size);
                }
            }
        }

        int largest = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    Map<Integer, Integer> islands = new HashMap<>();
                    for(int[] direction: directions) {
                        int r = i + direction[0];
                        int c = j + direction[1];
                        if(valid(r, c) && grid[r][c] == 1) {
                            int pos = parent[r * n + c];
                            islands.put(pos, sizes.get(pos));
                        }
                    }
                    int area = 0;
                    for(int island: islands.values()) {
                        area += island;
                    }
                    largest = Math.max(largest, area + 1);
                }
            }
        }

        if(largest == 0) {
            for(int size: sizes.values()) largest = Math.max(largest, size);
        }

        return largest;
    }

    private int dfs(int[][] grid, int i, int j, int island, int[] parent, Set<Integer> visited) {
        int pos = i * n + j;
        if(!valid(i, j) || visited.contains(pos) || grid[i][j] == 0) return 0;

        visited.add(pos);
        parent[pos] = island;
        int size = 1;
        for(int[] direction: directions) {
            size += dfs(grid, i + direction[0], j + direction[1], island, parent, visited);
        }

        return size;
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
