import java.util.HashMap;
import java.util.Map;

public class LC219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                if(i - idx <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
