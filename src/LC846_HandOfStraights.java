import java.util.TreeMap;

public class LC846_HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int num: hand) {
            tmap.put(num, tmap.getOrDefault(num, 0) + 1);
        }

        while(!tmap.isEmpty()) {
            int first = tmap.firstKey();
            for(int i = first; i < first + W; i++) {
                if(!tmap.containsKey(i)) return false;
                int cnt = tmap.get(i);
                if(cnt == 1) tmap.remove(i);
                else tmap.put(i, cnt - 1);
            }
        }

        return true;
    }
}
