import java.util.LinkedList;
import java.util.Queue;

public class LC864_Shortest_PathToGetAllKeys {
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int r = 0, c = 0;
        int allKeys = 0;
        char[][] gridA = new char[m][n];
        boolean[][][] visited = new boolean[m][n][1 << 6];
        for(int i = 0; i < m; i++) {
            char[] row = grid[i].toCharArray();
            for(int j = 0; j < n; j++) {
                gridA[i][j] = row[j];
                if(row[j] == '@') {
                    r = i;
                    c = j;
                } else if(row[j] >= 'a' && row[j] <= 'f') {
                    allKeys |= 1 << (row[j] - 'a');
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c][0] = true;

        int steps = 0;
        while(!q.isEmpty()) {
            int cnt = q.size();
            for(; cnt > 0; cnt--) {
                int[] cur = q.poll();
                if(cur[2] == allKeys) return steps;

                for(int[] direction: directions) {
                    int nr = cur[0] + direction[0];
                    int nc = cur[1] + direction[1];
                    if(!valid(gridA, nr, nc)) continue;

                    int key = cur[2];
                    if(gridA[nr][nc] >= 'A' && gridA[nr][nc] <= 'F') {
                        int offset = gridA[nr][nc] - 'A';
                        if(((key >> offset) & 1) == 0) continue;
                    }

                    if(gridA[nr][nc] >= 'a' && gridA[nr][nc] <= 'f') key |= 1 << (gridA[nr][nc] - 'a');

                    if(visited[nr][nc][key]) continue;

                    visited[nr][nc][key] = true;
                    q.offer(new int[]{nr, nc, key});
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean valid(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != '#';
    }
}
