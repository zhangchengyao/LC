import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC317_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int[][] totalDist = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, totalDist);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    res = Math.min(res, totalDist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private void bfs(int[][] grid, int x, int y, int[][] totalDist){
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int start = x * n + y;
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int dist = 0;
        int cnt;
        while(!q.isEmpty()){
            cnt = q.size();
            dist++;
            for(int i = 0; i < cnt; i++){
                int cur = q.poll();
                if(cur-n >= 0 && grid[(cur-n)/n][(cur-n)%n] == 0 && !visited[cur-n]){
                    q.offer(cur-n);
                    visited[cur - n] = true;
                    totalDist[(cur-n)/n][(cur-n)%n] += dist;
                }
                if(cur+n < m*n && grid[(cur+n)/n][(cur+n)%n] == 0 && !visited[cur+n]){
                    q.offer(cur+n);
                    visited[cur + n] = true;
                    totalDist[(cur+n)/n][(cur+n)%n] += dist;
                }
                if(cur-1 >= 0 && (cur-1)/n == cur/n && grid[(cur-1)/n][(cur-1)%n] == 0 && !visited[cur-1]){
                    q.offer(cur-1);
                    visited[cur-1] = true;
                    totalDist[(cur-1)/n][(cur-1)%n] += dist;
                }
                if(cur+1 < m*n && (cur+1)/n == cur/n && grid[(cur+1)/n][(cur+1)%n] == 0 && !visited[cur+1]){
                    q.offer(cur+1);
                    visited[cur+1] = true;
                    totalDist[(cur+1)/n][(cur+1)%n] += dist;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i*n+j] && grid[i][j] == 0) grid[i][j] = -1;
            }
        }
    }
}