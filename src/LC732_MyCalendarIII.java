import java.util.TreeMap;

public class LC732_MyCalendarIII {
    private TreeMap<Integer, Integer> tmap;

    public LC732_MyCalendarIII() {
        tmap = new TreeMap<>();
    }

    public int book(int start, int end) {
        tmap.put(start, tmap.getOrDefault(start, 0) + 1);
        tmap.put(end, tmap.getOrDefault(end, 0) - 1);

        int K = 0;
        int cur = 0;
        for(int val: tmap.values()) {
            cur += val;
            K = Math.max(K, cur);
        }

        return K;
    }
}
