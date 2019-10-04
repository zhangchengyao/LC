import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC857_MinimumCostToHireKWorkers {
    class Worker{
        int Q;
        int W;
        double ratio;
        Worker(int quality, int wage){
            Q = quality;
            W = wage;
            ratio = Q * 1.0 / W;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for(int i = 0; i < workers.length ; i++) workers[i] = new Worker(quality[i], wage[i]);

        Arrays.sort(workers, (a, b) -> Double.compare(b.ratio, a.ratio));

        PriorityQueue<Worker> maxHeap = new PriorityQueue<>((a, b) -> b.Q-a.Q);

        double res = Double.MAX_VALUE;
        double sum = 0.0;
        for (Worker worker : workers) {
            maxHeap.offer(worker);
            sum += worker.Q;
            if (maxHeap.size() > K) sum -= maxHeap.poll().Q;
            if (maxHeap.size() == K) res = Math.min(res, sum / worker.ratio);
        }
        return res;
    }
}
