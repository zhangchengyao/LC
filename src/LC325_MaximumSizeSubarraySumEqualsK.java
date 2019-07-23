import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC325_MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int longest = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        for(int key: map.keySet()) {
            if(key == k) {
                List<Integer> list = map.get(key);
                longest = Math.max(longest, list.get(list.size() - 1) + 1);
            } else {
                int diff = key - k;
                if(map.containsKey(diff)){
                    List<Integer> list1 = map.get(diff);
                    List<Integer> list2 = map.get(key);
                    if(list1.get(0) < list2.get(list2.size() - 1)) {
                        longest = Math.max(longest, list2.get(list2.size() - 1) - list1.get(0));
                    }
                }
            }
        }

        return longest;
    }
}
