import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            map.putIfAbsent(c, i);
        }

        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int end = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if(end == i) {
                res.add(i - prev);
                prev = i;
            }
        }

        return res;
    }
}
