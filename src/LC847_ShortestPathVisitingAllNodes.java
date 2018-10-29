import java.util.HashMap;

public class LC847_ShortestPathVisitingAllNodes {
    // Floyd + dp
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j) dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<n;i++){
            int[] dests = graph[i];
            for(int dest: dests) dist[i][dest] = 1;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE) dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(0+" "+i, 0);
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                String s = i+" "+j;
                if(!map.containsKey(s)) continue;
                int d = map.get(s);
                for(int k=0;k<n;k++){
                    int nextState = i | (1<<k);
                    String ns = nextState+" "+k;
                    if(!map.containsKey(ns) || map.get(ns)>d+dist[j][k]) map.put(ns, d+dist[j][k]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, map.get(((1<<n)-1)+" "+i));
        }
        return res;
    }
}
