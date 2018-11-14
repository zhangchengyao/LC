import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LC743_NetworkDelayTime {
    class Edge{
        int dest;
        int weight;
        Edge(int _dest, int _weight){
            dest = _dest;
            weight = _weight;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        if(N==1) return 0;
        int res = Integer.MIN_VALUE;

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int[] time: times){
            if(graph[time[0]]==null) graph[time[0]] = new ArrayList<>();
            graph[time[0]].add(new Edge(time[1], time[2]));
        }
        if(graph[K]==null) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(K);
        for(Edge e: graph[K]) pq.offer(new int[]{e.dest, e.weight});

        for(int i=0;i<N-1;i++){
            int[] cur = pq.poll();
            if(cur==null) return -1;
            while(!pq.isEmpty() && visited.contains(cur[0])) cur = pq.poll();
            if(visited.contains(cur[0])) return -1;
            visited.add(cur[0]);
            if(graph[cur[0]]!=null){
                for(Edge e: graph[cur[0]]){
                    pq.offer(new int[]{e.dest, e.weight+cur[1]});
                }
            }
            if(i==N-2) res = cur[1];
        }
        return res;
    }
}
