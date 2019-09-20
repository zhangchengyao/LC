import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];
        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if(graph[a] == null) graph[a] = new ArrayList<>();
            if(graph[b] == null) graph[b] = new ArrayList<>();
            graph[a].add(b);
            graph[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        List<Integer> res = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] <= 1) {
                q.offer(i);
            }
        }

        if(q.size() == 1) {
            res.add(q.poll());
            return res;
        }

        while(!q.isEmpty()) {
            int cnt = q.size();
            for(int i = 0; i < cnt; i++) {
                int cur = q.poll();
                degree[cur] = -1;
                for(int neighbor: graph[cur]) {
                    degree[neighbor]--;
                    if(degree[neighbor] == 0) {
                        res.add(neighbor);
                        if(i != cnt - 1) res.add(cur);
                        break;
                    }
                    if(degree[neighbor] == 1) q.offer(neighbor);
                }
            }
        }

        return res;
    }
}
