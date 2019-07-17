import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC254_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        getRec(n, 2, res, new ArrayList<>());
//        if(!res.isEmpty()) res.remove(res.size()-1);
        return res;
    }
    private void getRec(int n, int factor, List<List<Integer>> res, List<Integer> tmp){
        if(n == 1){
            if(!tmp.isEmpty()) res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i = factor; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                tmp.add(i);
                tmp.add(n/i);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                getRec(n/i, i, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
