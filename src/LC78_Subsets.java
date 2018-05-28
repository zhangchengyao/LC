import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        subset(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    private void subset(int[] nums, int start, List<List<Integer>> res, List<Integer> tmp){
        if(start==nums.length) return;
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            subset(nums, i+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
