import java.util.HashMap;
import java.util.Map;

public class LC219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2 || k<1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k) return true;
                else map.replace(nums[i], i);
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
