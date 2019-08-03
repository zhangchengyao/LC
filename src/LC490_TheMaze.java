import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC490_TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visited.add(start[0] * n + start[1]);
        q.offer(start[0] * n + start[1]);

        while(!q.isEmpty()) {
            int pos = q.poll();
            int curR = pos / n;
            int curC = pos % n;
            if(curR == destination[0] && curC == destination[1]) return true;
            for(int[] dir: directions) {
                int nextPos = getNextPos(maze, curR, curC, dir);
                if(nextPos != pos && !visited.contains(nextPos)) {
                    q.offer(nextPos);
                    visited.add(nextPos);
                }
            }
        }

        return false;
    }

    private int getNextPos(int[][] maze, int curR, int curC, int[] dir) {
        int m = maze.length;
        int n = maze[0].length;
        while(valid(m, n, curR, curC) && maze[curR][curC] == 0) {
            curR += dir[0];
            curC += dir[1];
        }
        curR -= dir[0];
        curC -= dir[1];

        return curR * n + curC;
    }

    private boolean valid(int m, int n, int curR, int curC) {
        return curR >= 0 && curR < m && curC >= 0 && curC < n;
    }
}
