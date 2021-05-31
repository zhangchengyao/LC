import java.util.HashMap;

public class LC325_MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int longest = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                longest = Math.max(longest, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }


        return longest;
    }
}
