import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC677_MapSumPairs {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public LC677_MapSumPairs() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> cur = it.next();
            if(cur.getKey().length()<prefix.length()) continue;
            if(cur.getKey().substring(0, prefix.length()).equals(prefix)) sum += cur.getValue();
        }
        return sum;
    }
}
