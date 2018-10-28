import java.util.ArrayList;

public class LC787_CheapestFlightsWithinKStops {
    // todo Bellman Ford algorithm
    class Edge{
        int dest;
        int weight;
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    int shortest = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<Edge>[] v = new ArrayList[n];
        for (int[] flight : flights) {
            Edge edge = new Edge(flight[1], flight[2]);
            if (v[flight[0]] == null) v[flight[0]] = new ArrayList<>();
            v[flight[0]].add(edge);
        }
        dfs(v, src, dst, K, -1, 0);
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
    private void dfs(ArrayList<Edge>[] v, int src, int dst, int K, int stop, int curMin){
        if(stop==K || v[src]==null) return ;
        for(Edge e: v[src]){
            if(e.dest==dst){
                shortest = Math.min(shortest, curMin+e.weight);
                continue;
            }
            if(curMin+e.weight<shortest)
                dfs(v, e.dest, dst, K, stop+1, curMin+e.weight);
        }
    }
}
