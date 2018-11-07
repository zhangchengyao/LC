import java.util.ArrayList;

public class LC787_CheapestFlightsWithinKStops {
    // dynamic programming
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        int[][] dist = new int[K+2][n];
//        for(int[] d: dist) Arrays.fill(d, Integer.MAX_VALUE);
//        dist[0][src] = 0;
//        for(int i=1;i<=K+1;i++){
//            dist[i][src] = 0;
//            for(int[] edge: flights){
//                if(dist[i-1][edge[0]]!=Integer.MAX_VALUE && dist[i-1][edge[0]] + edge[2]<dist[i][edge[1]]){
//                    dist[i][edge[1]] = dist[i-1][edge[0]] + edge[2];
//                }
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for(int i=0;i<=K+1;i++){
//            res = Math.min(res, dist[i][dst]);
//        }
//        return res==Integer.MAX_VALUE?-1:res;
//    }
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
