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
            ratio = Q*1.0/W;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for(int i=0;i<workers.length;i++) workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers, (a, b) -> Double.compare(b.ratio, a.ratio));
        PriorityQueue<Worker> maxHeap = new PriorityQueue<>(11, new Comparator<Worker>(){
            public int compare(Worker a, Worker b){
                return b.Q-a.Q;
            }
        });
        double res = Double.MAX_VALUE;
        double sum = 0.0;
        for(int i=0;i<workers.length;i++){
            maxHeap.offer(workers[i]);
            sum += workers[i].Q;
            if(maxHeap.size()>K) sum -= maxHeap.poll().Q;
            if(maxHeap.size()==K) res = Math.min(res, sum/workers[i].ratio);
        }
        // for(int i=0;i<K-1;i++) maxHeap.offer(workers[i]);
        // for(int i=K-1;i<workers.length;i++){
        //     double ratio = workers[i].ratio;
        //     double sum = workers[i].W*1.0;
        //     ArrayList<Worker> list = new ArrayList<>();
        //     while(!maxHeap.isEmpty()){
        //         sum += maxHeap.peek().Q/ratio;
        //         list.add(maxHeap.poll());
        //     }
        //     res = Math.min(res, sum);
        //     for(Worker w: list) maxHeap.offer(w);
        //     if(!maxHeap.isEmpty() && workers[i].Q<maxHeap.peek().Q){
        //         maxHeap.poll();
        //         maxHeap.offer(workers[i]);
        //     }
        // }
        return res;
    }
}
