import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC882_ReachableNodesInSubdividedGraph {
    class Node {
        int id;
        int dist;

        Node(int _id, int _dist) {
            id = _id;
            dist = _dist;
        }
    }

    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Integer>[] graph = new HashMap[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++ ) graph[i] = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];
            graph[a].put(b, weight);
            graph[b].put(a, weight);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        Node cur = new Node(0, 0);
        pq.offer(cur);

        int cnt = 0;
        while(!pq.isEmpty()) {
            cur = pq.poll();
            if(visited[cur.id]) continue;

            visited[cur.id] = true;
            cnt++;

            Map<Integer, Integer> es = graph[cur.id];
            for(int to: es.keySet()) {
                int weight = es.get(to);
                int dist = cur.dist + weight + 1;

                if(visited[to]) {
                    cnt += Math.min(weight, M - cur.dist);
                } else {
                    if(dist <= M) {
                        cnt += weight;
                        graph[to].put(cur.id, 0);
                        pq.offer(new Node(to, dist));
                    } else {
                        cnt += M - cur.dist;
                        graph[to].put(cur.id, weight - (M - cur.dist));
                    }
                }
            }
        }

        return cnt;
    }
}
