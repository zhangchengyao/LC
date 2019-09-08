import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1168_OptimizeWaterDistributionInAVillage {
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

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for(int i = 0; i < wells.length; i++) {
            pq.offer(new Edge(0, i + 1, wells[i]));
        }
        for(int[] pipe: pipes) {
            pq.offer(new Edge(pipe[0], pipe[1], pipe[2]));
        }

        int[] parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int cost = 0;
        for(int i = 0; i < n; i++) {
            Edge cur = pq.poll();
            while(!pq.isEmpty() && find(parent, cur.from) == find(parent, cur.to)) cur = pq.poll();
            cost += cur.cost;
            union(parent, cur.from, cur.to);
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
        if(root1 != root2) parent[root1] = root2;
    }
}
