import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        for(int i = 0; i < graph.length; i++){
            if(graph[i].length != 0 && !a.contains(i) && !b.contains(i)){
                boolean res = bfs(graph, i, a, b);
                if(!res) return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int start, HashSet<Integer> a, HashSet<Integer> b){
        int n = graph.length;

        a.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int neighbor: graph[cur]){
                if(a.contains(cur)){
                    if(a.contains(neighbor)) return false;
                    if(!b.contains(neighbor)){
                        b.add(neighbor);
                        q.offer(neighbor);
                    }
                } else {
                    if(b.contains(neighbor)) return false;
                    if(!a.contains(neighbor)){
                        a.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
        }

        return true;
    }
}
