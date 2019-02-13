import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> tmp){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i < nums.length; i++){
            swap(nums, start, i);
            tmp.add(nums[start]);
            helper(nums, start + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
