import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T) return 0;
        int numBus = routes.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); // stop => buses going by this stop
        for(int i=0;i<numBus;i++){
            for(int j: routes[i]){
                HashSet<Integer> set = map.getOrDefault(j, new HashSet<>());
                set.add(i);
                map.put(j, set);
            }
        }
        boolean[] seen = new boolean[numBus];
        int layer = 1;
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        while(!q.isEmpty()){
            cnt = q.size();
            for(int i=0;i<cnt;i++){
                int curStop = q.poll();
                HashSet<Integer> buses = map.get(curStop);
                for(int bus: buses){
                    if(seen[bus]) continue;
                    seen[bus] = true;
                    for(int stop: routes[bus]){
                        if(stop==T) return layer;
                        q.offer(stop);
                    }
                }
            }
            layer++;
        }
        return -1;
    }
}
