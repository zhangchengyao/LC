import java.util.*;

public class LC347_TopKFrequentElements {
    // O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key: count.keySet()){
            int val = count.get(key);
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i--){
            if(bucket[i] == null) continue;

            for(int num: bucket[i]){
                res.add(num);
                if(res.size() == k) break;
            }
        }

        return res;
    }

//    public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> count = new HashMap<>();
//        for(int num: nums){
//            count.put(num, count.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Integer> MinHeap = new PriorityQueue<>((x, y) -> count.get(x) - count.get(y));
//
//        for(int key: count.keySet()){
//            MinHeap.offer(key);
//            if(MinHeap.size() > k){
//                MinHeap.poll();
//            }
//        }
//
//        return new ArrayList<>(MinHeap);
//    }
}
