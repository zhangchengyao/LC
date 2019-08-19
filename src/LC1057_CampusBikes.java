import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1057_CampusBikes {
    class Pair{
        int worker;
        int bike;
        int dist;
        Pair(int _worker, int _bike, int _dist) {
            worker = _worker;
            bike = _bike;
            dist = _dist;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist == b.dist ? (a.worker == b.worker ? a.bike - b.bike : a.worker - b.worker) : a.dist - b.dist);
        for(int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for(int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                pq.add(new Pair(i, j, Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1])));
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] occupied = new boolean[bikes.length];
        int cnt = 0;
        while(cnt < workers.length) {
            Pair cur = pq.poll();
            if(res[cur.worker] == -1 && !occupied[cur.bike]) {
                res[cur.worker] = cur.bike;
                occupied[cur.bike] = true;
                cnt++;
            }
        }

        return res;
    }
}
