import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC710_RandomPickWithBlacklist {
    private Map<Integer, Integer> map;
    private int size;

    public LC710_RandomPickWithBlacklist(int N, int[] blacklist) {
        Set<Integer> set = new HashSet<>();
        for(int n: blacklist) set.add(n);

        map = new HashMap<>();
        size = N - blacklist.length;
        int cur = size;
        for(int blackNum: blacklist) {
            if(blackNum < size) {
                while(set.contains(cur)) cur++;
                map.put(blackNum, cur++);
            }
        }
    }

    public int pick() {
        int cand = (int)(Math.random() * size);
        return map.getOrDefault(cand, cand);
    }
}
