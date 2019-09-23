import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c: S.toCharArray()) {
            map.put(c, i++);
        }

        List<Integer> res = new ArrayList<>();
        i = 0;
        while(i < S.length()) {
            int j = i;
            int end = map.get(S.charAt(j));
            while(j < end) {
                j++;
                end = Math.max(end, map.get(S.charAt(j)));
            }
            res.add(j - i + 1);
            i = j + 1;
        }

        return res;
    }
}
