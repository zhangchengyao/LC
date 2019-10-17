import java.util.Arrays;

public class LC803_BricksFallingWhenHit {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int[] sizes = new int[m * n];

        for(int[] hit: hits) {
            grid[hit[0]][hit[1]]--;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int idx = i * n + j;
                if(grid[i][j] == 1) {
                    if(parents[idx] == -1) sizes[idx] = dfs(grid, i, j, parents, idx);
                } else {
                    parents[idx] = idx;
                    sizes[idx] = 1;
                }
            }
        }

        int[] res = new int[hits.length];
        int t = res.length - 1;
        while(t >= 0) {
            int r = hits[t][0];
            int c = hits[t][1];
            if(grid[r][c] == -1) {
                t--;
                continue;
            }

            int cur = r * n + c;
            boolean hitRoof = (find(parents, cur) / n == 0);
            int prevSz = 0;
            for(int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(valid(m, n, nr, nc) && grid[nr][nc] == 1) {
                    int idx = nr * n + nc;
                    int root = find(parents, idx);
                    if(root / n == 0) {
                        if(find(parents, cur) != root) prevSz += sizes[root];
                        union(parents, sizes, idx, cur);
                    } else {
                        union(parents, sizes, cur, idx);
                    }
                }
            }

            if(grid[r][c] == 0) grid[r][c] = 1;

            if(prevSz == 0 && hitRoof) res[t--] = sizes[find(parents, cur)] - 1;
            else res[t--] = prevSz == 0 ? 0 : sizes[find(parents, cur)] - prevSz - 1;
        }

        return res;
    }

    private int dfs(int[][] grid, int r, int c, int[] parents, int root) {
        int m = grid.length;
        int n = grid[0].length;
        if(!valid(m, n, r, c) || grid[r][c] != 1) return 0;

        int idx = r * n + c;
        if(parents[idx] == root) return 0;

        int size = 1;
        parents[idx] = root;
        for(int[] dir: directions) {
            size += dfs(grid, r + dir[0], c + dir[1], parents, root);
        }

        return size;
    }

    private int find(int[] parents, int a) {
        while(a != parents[a]) {
            a = parents[a];
        }

        return a;
    }

    private void union(int[] parents, int[] sizes, int a, int b) {
        int root1 = find(parents, a);
        int root2 = find(parents, b);
        if(root1 == root2) return;

        parents[root2] = root1;
        sizes[root1] += sizes[root2];
    }

    private boolean valid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    // running time might be high
//    private int num;
//    private int cnt = 0;
//    public int[] hitBricks(int[][] grid, int[][] hits) {
//        int[] res = new int[hits.length];
//        if(grid.length == 0 || hits.length == 0) return res;
//        int[] xDirect = new int[]{0, 0, 1, -1};
//        int[] yDirect = new int[]{1, -1, 0, 0};
//        int[][] visited = new int[grid.length][grid[0].length];
//        for(int i = 0;i < hits.length; i++){
//            int x = hits[i][0];
//            int y = hits[i][1];
//            if(grid[x][y] == 1){
//                grid[x][y] = 0;
//                for(int t = 0; t < 4; t++){
//                    cnt++;
//                    num = 0;
//                    int r = x + xDirect[t];
//                    int c = y + yDirect[t];
//                    if(!check(grid, r, c, visited)){
//                        res[i] += num;
//                        cnt++;
//                        drop(grid, r, c, visited);
//                    }
//                }
//
//            }
//            else res[i] = 0;
//        }
//        return res;
//    }
//    private boolean check(int[][] grid, int i, int j, int[][] visited){
//        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == cnt || grid[i][j] == 0) return false;
//        if(i == 0 && grid[i][j] == 1) return true;
//        num++;
//        visited[i][j] = cnt;
//        return check(grid, i - 1, j, visited) || check(grid, i + 1, j, visited) || check(grid, i, j - 1, visited) || check(grid, i, j + 1, visited);
//    }
//    private void drop(int[][] grid, int i, int j, int[][] visited){
//        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == cnt || grid[i][j] == 0) return;
//        visited[i][j] = cnt;
//        grid[i][j] = 0;
//        drop(grid, i - 1, j, visited);
//        drop(grid, i + 1, j, visited);
//        drop(grid, i, j - 1, visited);
//        drop(grid, i, j + 1, visited);
//    }
}
