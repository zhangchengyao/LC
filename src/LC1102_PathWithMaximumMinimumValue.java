import java.util.PriorityQueue;

public class LC1102_PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> A[b[0]][b[1]] - A[a[0]][a[1]]);
        boolean[][] visited = new boolean[R][C];
        pq.offer(new int[]{0, 0});

        int score = Integer.MAX_VALUE;
        while(true) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            visited[r][c] = true;
            score = Math.min(score, A[r][c]);
            if(r == R - 1 && c == C - 1) break;
            for(int[] dir: dirs) {
                if(isValid(R, C, r + dir[0], c + dir[1]) && !visited[r + dir[0]][c + dir[1]]) {
                    pq.offer(new int[]{r + dir[0], c + dir[1]});
                }
            }
        }

        return score;
    }

    private boolean isValid(int R, int C, int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
