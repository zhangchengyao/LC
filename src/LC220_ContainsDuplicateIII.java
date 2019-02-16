import java.util.TreeSet;

public class LC220_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2 || k < 1) return false;

        TreeSet<Long> tset = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            Long low = tset.floor((long)nums[i]);
            Long high = tset.ceiling((long)nums[i]);
            if((low != null && nums[i] - low <= t) || (high != null && high - nums[i] <= t)) return true;

            if(i - k >= 0) tset.remove((long)nums[i - k]);
            tset.add((long)nums[i]);
        }

        return false;
    }
}
