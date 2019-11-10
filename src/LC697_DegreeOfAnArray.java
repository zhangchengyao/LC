import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC697_DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new int[3]);
            map.get(nums[i])[0]++;
            if(map.get(nums[i])[0] == 1) {
                map.get(nums[i])[1] = i;
            }
            map.get(nums[i])[2] = i;
            degree = Math.max(degree, map.get(nums[i])[0]);
        }

        int minLen = nums.length;
        for(int[] info: map.values()) {
            if(info[0] == degree) {
                minLen = Math.min(minLen, info[2] - info[1] + 1);
            }
        }

        return minLen;
    }
}
