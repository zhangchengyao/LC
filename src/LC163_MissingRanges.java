import java.util.ArrayList;
import java.util.List;

public class LC163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            res.add(lower == upper ? lower + "" : lower + "->" + upper);
            return res;
        }
        if(lower < nums[0]){
            if(lower == nums[0] - 1) res.add("" + lower);
            else res.add(lower + "->" + (nums[0] - 1));
        }
        int i = 0;
        for(;i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) continue;

            if(nums[i] + 1 != nums[i+1]){
                if(nums[i] + 2 == nums[i+1]) res.add("" + (nums[i] + 1));
                else res.add((nums[i] + 1) + "->" + (nums[i+1] - 1));
            }
        }
        if(nums[i] < upper){
            if(nums[i] == upper - 1) res.add("" + upper);
            else res.add((nums[i] + 1) + "->" + upper);
        }
        return res;
    }
}
