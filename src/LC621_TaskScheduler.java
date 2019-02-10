import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] num = new int[26];
        for(int i=0;i<tasks.length;i++){
            num[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<num.length;i++){
            if(num[i]!=0) maxHeap.offer(num[i]);
        }
        int res = 0;
        while(!maxHeap.isEmpty()){
            int cnt = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                    tmp.add(maxHeap.poll()-1);
                    cnt ++;
                }
            }
            for(Integer i:tmp){
                if(i!=0) maxHeap.offer(i);
            }
            if(!maxHeap.isEmpty()) res += n+1;
            else res += cnt;
        }
        return res;
    }
}
