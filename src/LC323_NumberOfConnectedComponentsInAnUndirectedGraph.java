import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC323_NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if(n<1) return 0;
        int res = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int[] e: edges){
            if(graph[e[0]]==null) graph[e[0]] = new ArrayList<>();
            if(graph[e[1]]==null) graph[e[1]] = new ArrayList<>();
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && graph[i]!=null){
                bfs(graph, i, visited);
                res++;
            }
            else if(graph[i]==null) res++;
        }
        return res;
    }
    private void bfs(ArrayList<Integer>[] graph, int v, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int to: graph[cur]){
                if(!visited[to]){
                    visited[to] = true;
                    q.offer(to);
                }
            }
        }
    }
}
