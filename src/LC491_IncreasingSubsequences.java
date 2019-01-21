import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC491_IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsequences(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void findSubsequences(int[] nums, int start, List<List<Integer>> res, List<Integer> seq){
        if(seq.size()>=2) {
            res.add(new ArrayList<>(seq));
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(!set.contains(nums[i]) && (seq.isEmpty() || nums[i]>=seq.get(seq.size()-1)) ){
                seq.add(nums[i]);
                set.add(nums[i]);
                findSubsequences(nums, i+1, res, seq);
                seq.remove(seq.size()-1);
            }
        }
    }
}
