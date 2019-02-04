import java.util.HashMap;

public class LC594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for(int key: count.keySet()){
            if(count.containsKey(key - 1)){
                max = Math.max(max, count.get(key) + count.get(key-1));
            }
        }

        return max;
    }
}
