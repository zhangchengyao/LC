import java.util.ArrayList;
import java.util.List;

public class LC830_PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int i = 0;
        while(i<S.length()){
            int j = i+1;
            while(j<S.length() && S.charAt(j)==S.charAt(j-1)) j++;
            if(j-i>=3){
                tmp.add(i);
                tmp.add(j-1);
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
            i = j;
        }
        return res;
    }
}
