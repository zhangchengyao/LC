import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int smallSeq = 0;
        for(int n: nums) {
            List<Integer> list = map.get(n - 1);
            map.putIfAbsent(n, new ArrayList<>());
            if(list != null && list.size() > 0) {
                int len = list.remove(list.size() - 1);
                map.get(n).add(len + 1);
                map.get(n).sort(Comparator.reverseOrder());
                if(len == 2) smallSeq--;
            } else {
                map.get(n).add(1);
                smallSeq++;
            }
        }

        return smallSeq == 0;
    }
}
