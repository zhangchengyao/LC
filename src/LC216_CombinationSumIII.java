import java.util.ArrayList;
import java.util.List;

public class LC216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combineRec(k, n, 1, res, new ArrayList<Integer>());
        return res;
    }
    private void combineRec(int k, int n, int min, List<List<Integer>> res, List<Integer> tmp){
        if(k==0){
            if(n==0){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for(int i=min;i<=9;i++){
            tmp.add(i);
            combineRec(k-1, n-i, i+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
