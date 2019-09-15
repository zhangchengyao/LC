import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC697_DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            degree = Math.max(degree, map.get(nums[i]).size());
        }

        int minLen = nums.length;
        for(List<Integer> indices: map.values()) {
            if(indices.size() == degree) {
                minLen = Math.min(minLen, indices.get(indices.size() - 1) - indices.get(0) + 1);
            }
        }

        return minLen;
    }
}
