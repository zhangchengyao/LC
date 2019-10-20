import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC826_MostProfitAssigningWork {
    class Job {
        int difficulty;
        int profit;
        Job(int d, int p) {
            difficulty = d;
            profit = p;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.difficulty));
        for(int i = 0; i < profit.length; i++) {
            pq.offer(new Job(difficulty[i], profit[i]));
        }

        Arrays.sort(worker);
        int res = 0;
        int max = 0;
        for(int w: worker) {
            while(!pq.isEmpty() && pq.peek().difficulty <= w) {
                max = Math.max(max, pq.poll().profit);
            }
            res += max;
        }

        return res;
    }
}
