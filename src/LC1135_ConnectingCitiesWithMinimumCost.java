import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1135_ConnectingCitiesWithMinimumCost {
    class Edge {
        int from;
        int to;
        int cost;
        Edge(int _from, int _to, int _cost) {
            from = _from;
            to = _to;
            cost = _cost;
        }
    }

    public int minimumCost(int N, int[][] connections) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        for(int[] conn: connections) {
            pq.offer(new Edge(conn[0] - 1, conn[1] - 1, conn[2]));
        }

        int[] parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cost = 0;
        for(int i = 0; i < N - 1; i++) {
            if(pq.isEmpty()) return -1;

            Edge cur = pq.poll();
            while(!pq.isEmpty() && find(parent, cur.from) == find(parent, cur.to)) cur = pq.poll();
            if(find(parent, cur.from) == find(parent, cur.to)) return -1;

            union(parent, cur.from, cur.to);
            cost += cur.cost;
        }

        return cost;
    }

    private int find(int[] parent, int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }
    private void union(int[] parent, int x, int y) {
        int root1 = find(parent, x);
        int root2 = find(parent, y);
        if(root1 != root2) {
            parent[root1] = root2;
        }
    }
}
