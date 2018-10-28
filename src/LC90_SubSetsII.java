import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        subset(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    private void subset(int[] nums, int start, List<List<Integer>> res, List<Integer> tmp){
        if(start==nums.length) return;
        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i]==nums[i-1]) continue;
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            subset(nums, i+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
