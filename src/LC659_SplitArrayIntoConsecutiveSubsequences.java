import java.util.HashMap;
import java.util.PriorityQueue;

public class LC659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int sequenceLess3 = 0;
        for(int num: nums){
            if(map.containsKey(num-1)){
                PriorityQueue<Integer> minHeap = map.get(num-1);
                int tmp = minHeap.poll()+1;
                if(minHeap.isEmpty()) map.remove(num-1);
                PriorityQueue<Integer> h = map.getOrDefault(num, new PriorityQueue<>());
                h.offer(tmp);
                map.put(num, h);
                if(tmp==3) sequenceLess3--;
            }else{
                PriorityQueue<Integer> h = map.getOrDefault(num, new PriorityQueue<>());
                h.offer(1);
                map.put(num, h);
                sequenceLess3++;
            }
        }
        return sequenceLess3==0;
    }
}
