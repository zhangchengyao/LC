import java.util.Comparator;
import java.util.PriorityQueue;

public class LC871_MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int pos = startFuel;
        int stops = 0;
        int idx = 0;
        while(pos < target) {
            while(idx < stations.length && stations[idx][0] <= pos) pq.offer(stations[idx++][1]);

            if(pq.isEmpty()) return -1;

            stops++;
            pos += pq.poll();
        }

        return stops;
    }
}
