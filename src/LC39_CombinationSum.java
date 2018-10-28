import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
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
            tmp.add(candidates[i]);
            combine(candidates, i, target-candidates[i], tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
}
