import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC826_MostProfitAssigningWork {
    class Task{
        int difficulty;
        int profit;
        Task(int difficulty, int profit){
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int profits = 0;
        Arrays.sort(worker);
        PriorityQueue<Task> minHeap = new PriorityQueue<>(2, new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                return Integer.compare(t1.difficulty, t2. difficulty);
            }
        });
        for(int i=0;i<difficulty.length;i++){
            minHeap.offer(new Task(difficulty[i], profit[i]));
        }
        for(int i=0;i<worker.length;i++){
            int max = 0;
            int index = 0;
            ArrayList<Task> list = new ArrayList<>();
            int in = -1;
            while(!minHeap.isEmpty() && minHeap.peek().difficulty<=worker[i]){
                list.add(minHeap.poll());
                in++;
                if(list.get(in).profit>max){
                    max = list.get(in).profit;
                    index = in;
                }
            }
            if(!list.isEmpty()){
                profits += max;
                minHeap.offer(list.get(index));
            }
        }
        return profits;
    }
}
