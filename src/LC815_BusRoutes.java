import java.util.*;

public class LC815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;

        Map<Integer, List<Integer>> stop2Route = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int stop: routes[i]) {
                stop2Route.putIfAbsent(stop, new ArrayList<>());
                stop2Route.get(stop).add(i);
            }
        }

        boolean[] visited = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        int buses = 1;
        while(!q.isEmpty()) {
            int cnt = q.size();
            for(; cnt > 0; cnt--) {
                int stop = q.poll();
                if(stop == T) return buses;

                List<Integer> nextRoutes = stop2Route.get(stop);
                for(int route: nextRoutes) {
                    if(!visited[route]) {
                        visited[route] = true;
                        for(int next: routes[route]) {
                            if(next == T) return buses;
                            q.offer(next);
                        }
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}
