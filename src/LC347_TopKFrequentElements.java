import java.util.*;

public class LC347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
