import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC756_PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, List<Character>> map = new HashMap<>();
        for(String str: allowed) {
            String key = str.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str.charAt(2));
        }

        return canBuild(bottom, new StringBuilder(), 0, map);
    }

    private boolean canBuild(String cur, StringBuilder next, int idx, HashMap<String, List<Character>> map) {
        if(cur.length() == 1) return true;

        if(idx == cur.length() - 1) return canBuild(next.toString(), new StringBuilder(), 0, map);

        String key = cur.substring(idx, idx + 2);
        if(!map.containsKey(key)) return false;
        for(char c: map.get(key)) {
            next.append(c);
            if(canBuild(cur, next, idx + 1, map)) return true;
            next.deleteCharAt(next.length() - 1);
        }

        return false;
    }
}
