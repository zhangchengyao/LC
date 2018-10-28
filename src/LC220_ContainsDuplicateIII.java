import java.util.TreeSet;

public class LC220_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length<2 || k<1) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long ceil = set.ceiling((long)nums[i]);
            Long floor = set.floor((long)nums[i]);
            if((ceil!=null && ceil-nums[i]<=t) || (floor!=null && nums[i]-floor<=t)) return true;
            set.add((long)nums[i]);
            if(i-k>=0) set.remove((long)nums[i-k]);
        }
        return false;
    }
}
