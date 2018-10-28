import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, 0, target, tmp, res);
        return res;
    }
    private void combine(int[] candidates, int start, int target, List<Integer> tmp, List<List<Integer>> res){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            tmp.add(candidates[i]);
            combine(candidates, i+1, target-candidates[i], tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
}
