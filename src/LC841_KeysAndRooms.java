import java.util.*;

public class LC841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int room = q.poll();
            for(int key: rooms.get(room)) {
                if(!visited.contains(key)) {
                    visited.add(key);
                    q.offer(key);
                }
            }
        }

        return visited.size() == n;
    }
}
