import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC749_ContainVirus {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<Set<Integer>> infectedAreas;
    private List<Set<Integer>> frontiers;
    private List<Integer> requiredWalls;
    private Set<Integer> visited;

    public int containVirus(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int walls = 0;

        while(true) {
            infectedAreas = new ArrayList<>();
            frontiers = new ArrayList<>();
            requiredWalls = new ArrayList<>();
            visited = new HashSet<>();

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 && !visited.contains(i * n + j)) {
                        Set<Integer> visiting = new HashSet<>();
                        infectedAreas.add(new HashSet<>());
                        frontiers.add(new HashSet<>());
                        requiredWalls.add(0);
                        dfs(grid, i, j, visiting);
                    }
                }
            }

            if(infectedAreas.size() == 0) break;

            int choice = 0;
            for(int i = 0; i < infectedAreas.size(); i++) {
                if(frontiers.get(i).size() > frontiers.get(choice).size()) choice = i;
            }

            walls += requiredWalls.get(choice);

            for(int area: infectedAreas.get(choice)) {
                int r = area / n;
                int c = area % n;
                grid[r][c] = -1;
            }

            for(int i = 0; i < frontiers.size(); i++) {
                if(i == choice) continue;

                for(int area: frontiers.get(i)) {
                    int r = area / n;
                    int c = area % n;
                    grid[r][c] = 1;
                }
            }
        }

        return walls;
    }

    private void dfs(int[][] grid, int r, int c, Set<Integer> visiting) {
        if(invalid(grid, r, c) || grid[r][c] == -1) return ;

        int idx = infectedAreas.size() - 1;
        int num = r * grid[0].length + c;

        if(grid[r][c] == 0) {
            requiredWalls.set(idx, requiredWalls.get(idx) + 1);
            if(!visiting.contains(num)) {
                visiting.add(num);
                frontiers.get(idx).add(num);
            }
            return ;
        }

        if(visiting.contains(num)) return ;
        visiting.add(num);
        visited.add(num);

        infectedAreas.get(idx).add(num);

        for(int[] dir: directions) {
            dfs(grid, r + dir[0], c + dir[1], visiting);
        }
    }

    private boolean invalid(int[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length;
    }
}
