import java.util.LinkedList;
import java.util.Queue;

public class LC785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(color[i] == 0) {
                if(!bfs(graph, color, i)) return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int cur) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        color[cur] = 1;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int neighbor: graph[cur]) {
                if(color[cur] == color[neighbor]) return false;
                if(color[neighbor] == 0) {
                    q.offer(neighbor);
                    color[neighbor] = -color[cur];
                }
            }
        }

        return true;
    }
}
